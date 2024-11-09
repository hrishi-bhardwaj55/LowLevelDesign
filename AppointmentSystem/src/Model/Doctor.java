package Model;

import java.util.*;

public class Doctor {
    private String name;
    private String speciality;
    private int numRatings;
    private int totalRatings;
    private int rating;
    private final Map<String,TimeSlot> timeSlots = new HashMap<>();

    public Collection<TimeSlot> getTimeSlots() {
        return this.timeSlots.values();
    }

    public Map<String,TimeSlot> getTimeSlotMap() {
        return this.timeSlots;
    }


    public List<String> getTimeSlotsId() {
        List<String> timeSlotsId = new ArrayList<>();
        for (TimeSlot timeSlot : timeSlots.values()) {
            timeSlotsId.add(timeSlot.getId());
        }
        return timeSlotsId;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        for(TimeSlot timeSlot : timeSlots){
            this.timeSlots.put(timeSlot.getId(),timeSlot);
        }
    }


    public Doctor(String name, String speciality, List<TimeSlot> timeSlots) {
        this.name = name;
        this.speciality = speciality;
        for(TimeSlot timeSlot : timeSlots){
            this.timeSlots.put(timeSlot.getId(),timeSlot);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
