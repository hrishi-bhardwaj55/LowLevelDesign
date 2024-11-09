package Model;

public class Appointment {

    private String name;
    private TimeSlot timeslot;

    public Appointment(String name, TimeSlot timeslot) {
        this.name = name;
        this.timeslot = timeslot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeSlot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeSlot timeslot) {
        this.timeslot = timeslot;
    }
}
