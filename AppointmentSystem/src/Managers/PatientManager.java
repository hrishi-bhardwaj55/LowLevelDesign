package Managers;

import Model.Patient;
import Model.TimeSlot;

import java.util.HashMap;
import java.util.Map;

public class PatientManager {

    public Map<String, Patient> patientsMap = new HashMap<>();

    public void addPatient(Patient patient) {
        patientsMap.put(patient.getName(), patient);
    }

    public Patient getPatient(String name) {
        return patientsMap.get(name);
    }

    public boolean getPatientAvailabilityForTimeSlot(TimeSlot timeSlot, String patient) {
        return !patientsMap.get(patient).getTimeSlots().contains(timeSlot);
    }

    public void addTimeSlot(TimeSlot timeSlot, String patientName) {
        patientsMap.get(patientName).getTimeSlots().add(timeSlot);
    }
}
