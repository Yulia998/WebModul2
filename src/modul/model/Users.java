package modul.model;

public class Users {
    private int id;
    private String name;
    private int total;

    public Users(int id, String name, int total) {
        this.id = id;
        this.name = name;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
