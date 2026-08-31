import java.util.List;

public class LockService {
    private static final double STOPPED_SPEED_KMH = 0.1;
    private static final double MAX_SPEED_KMH = 3.0;
    private static final int MIN_SECONDS_BELOW = 5;
    private static final int MAX_READING_AGE_SECONDS = 10;

    public boolean canLock(List<SpeedReading> readings) {

        if (readings.isEmpty()) {
            return false;
        }

        SpeedReading last = readings.get(readings.size() - 1);

        if (last.getSpeedKmh() < STOPPED_SPEED_KMH) {
            return true;
        }

        return false;   // provisório
    }
}