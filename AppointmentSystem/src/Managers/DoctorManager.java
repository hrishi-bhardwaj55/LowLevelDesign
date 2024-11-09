package Managers;

import Exceptions.NoAvailableTimeSlot;
import Model.Doctor;
import Model.TimeSlot;

import java.util.*;

public class DoctorManager {

    Map<String, Doctor> doctorsMap = new HashMap<>();

    public void addDoctor(Doctor doctor) {
        doctorsMap.put(doctor.getName(), doctor);
    }

    public Doctor getDoctor(String name) {
        return doctorsMap.get(name);
    }

    public Collection<TimeSlot> getDoctorAvailability(String doctorName) throws NoAvailableTimeSlot {
        Doctor doctor = doctorsMap.get(doctorName);
        if (doctor != null) {
            return doctor.getTimeSlots();
        }

        throw new NoAvailableTimeSlot();
    }

    public List<Doctor> getAllDoctorsOfSpeciality(String speciality) {
        List<Doctor> doctors = new ArrayList<>();
        for (Doctor doctor : doctorsMap.values()) {
            if (doctor.getSpeciality().equals(speciality)) {
                doctors.add(doctor);
            }
        }
        return doctors;
    }

    public boolean getDoctorAvailabilityForTimeSlot(TimeSlot timeSlot, String doctor) {
        return doctorsMap.get(doctor).getTimeSlotsId().contains(timeSlot.getId());
    }

    public void removeTimeSlot(String timeSlot, String doctor) {
        Map<String, TimeSlot> timeSlotMap = doctorsMap.get(doctor).getTimeSlotMap();
        timeSlotMap.remove(timeSlot);
    }

}
