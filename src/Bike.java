public class Bike {

    private int id;
    private String name;
    private int ownerId;

    public Bike(int id, String name, int ownerId) {

        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

}
