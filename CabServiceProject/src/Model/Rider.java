package Model;

public class Rider {

    private String riderName;

    private double xLocation;

    private double yLocation;

    public Rider(String riderName, double xLocation, double yLocation) {
        this.riderName = riderName;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
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

