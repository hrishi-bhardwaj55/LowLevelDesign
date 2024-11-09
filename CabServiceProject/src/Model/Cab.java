package Model;

public class Cab {

    private int id;

    private String driverName;

    private double xLocation;

    private double yLocation;


    private boolean available;

    public Cab(String driverName, double xLocation, double yLocation, boolean available) {
        this.driverName = driverName;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getxLocation() {
        return xLocation;
    }

    public void setxLocation(double xLocation) {
        this.xLocation = xLocation;
    }

    public double getyLocation() {
        return yLocation;
    }

    public void setyLocation(double yLocation) {
        this.yLocation = yLocation;
    }

}
