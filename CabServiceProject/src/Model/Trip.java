package Model;

public class Trip {



    public Trip(double xDestination , double yDestination, Cab cab, Rider rider) {
        this.xDestination = xDestination;
        this.yDestination = yDestination;
        this.cab = cab;
        this.rider = rider;
        ++id;
    }

    public int getCabId() {
        return cabId;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public double getXDestination() {
        return xDestination;
    }

    public void setXDestination(double xDestination) {
        this.xDestination = xDestination;
    }

    public double getYDestination() {
        return yDestination;
    }

    public void setYDestination(double yDestination) {
        this.yDestination = yDestination;
    }

    public double getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    public void setTotalDistanceTraveled(double totalDistanceTraveled) {
        this.totalDistanceTraveled = totalDistanceTraveled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Rider ID: " + rider);
        System.out.println("destination " + xDestination +","+yDestination);
        System.out.println("Total distance traveled: " + totalDistanceTraveled);

    }

    private int cabId;

    private Rider rider;

    private Cab cab;

    private double xDestination;

    private double yDestination;

    private double totalDistanceTraveled;

    private int id = 0;

}
