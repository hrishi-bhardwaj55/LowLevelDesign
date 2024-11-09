package Managers;

import Model.Appointment;
import Model.TimeSlot;

import java.util.HashMap;
import java.util.Map;

public class AppointmentManager {

    Map<String, Appointment> doctorAppointments = new HashMap<>();
    Map<String, Appointment> patientAppointments = new HashMap<>();

    public void addDoctorAppointment(String doctor, String patient, TimeSlot timeSlot) {
        doctorAppointments.put(doctor,new Appointment(patient, timeSlot));
    }

    public void addPatientAppointment(String patient,String doctor, TimeSlot timeSlot) {
        patientAppointments.put(patient,new Appointment(doctor,timeSlot));
    }

    public Map<String, Appointment> getDoctorAppointments() {
        return doctorAppointments;
    }

    public Map<String, Appointment> getPatientAppointments() {
        return patientAppointments;
    }
}
