package Model;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String name;

    public Patient(String name) {
        this.name = name;
    }

    private List<TimeSlot> timeSlots = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }
}
