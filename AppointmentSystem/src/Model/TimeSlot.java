package Model;

public class TimeSlot {

    private int startTime;
    private int endTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public TimeSlot(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = startTime +"-"+ endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
