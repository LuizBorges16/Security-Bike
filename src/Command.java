import java.time.LocalDateTime;


public class Command {

    private int id;
    private int userId;
    private int bikeId;
    private CommandType type;
    private CommandStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime confirmedAt;
    private LocalDateTime failedAt;

    public Command(int id, int bikeId, int userId, CommandType type) {
        this.id = id;
        this.bikeId = bikeId;
        this.userId = userId;
        this.type = type;
        this.status = CommandStatus.PENDING;
        this.createdAt = LocalDateTime.now();
        this.confirmedAt = null;
        this.failedAt = null;
    }

    public int getId() {
        return this.id;
    }

    public int getBikeId() {
        return this.bikeId;
    }

    public int getUserId() {
        return this.userId;
    }

    public CommandType getType() {
        return this.type;
    }

    public LocalDateTime getConfirmedAt() {
        return confirmedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getFailedAt() {
        return failedAt;
    }

    public CommandStatus getStatus() {
        return status;
    }

    public void confirm() {
        this.status = CommandStatus.CONFIRMED;
        this.confirmedAt = LocalDateTime.now();
    }

    public void fail() {
        this.status = CommandStatus.FAILED;
        this.failedAt = LocalDateTime.now();
    }

}
