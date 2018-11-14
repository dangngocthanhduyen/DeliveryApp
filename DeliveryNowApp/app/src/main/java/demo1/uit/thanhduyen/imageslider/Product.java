package demo1.uit.thanhduyen.imageslider;

public class Product {
    private int id;
    private String name;
    private String address;
    private double distance;

    //Constructor

    public Product(int id, String name, String address, double distance){
        this.id = id;
        this.name = name;
        this.address = address;
        this.distance = distance;
    }


    //Setter, getter

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}