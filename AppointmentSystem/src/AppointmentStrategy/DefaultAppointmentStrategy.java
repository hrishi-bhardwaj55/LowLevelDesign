package AppointmentStrategy;

import Exceptions.DoctorNotAvailableException;
import Exceptions.NoAvailableTimeSlot;
import Exceptions.PatientAlreadyHasAppointmentException;
import Managers.AppointmentManager;
import Managers.DoctorManager;
import Managers.PatientManager;
import Model.Doctor;
import Model.TimeSlot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultAppointmentStrategy implements IAppointmentStrategy{

    DoctorManager doctorManager;
    PatientManager patientManager;
    AppointmentManager appointmentManager;

    public DefaultAppointmentStrategy(DoctorManager doctorManager, PatientManager patientManager, AppointmentManager appointmentManager) {
        this.doctorManager = doctorManager;
        this.patientManager = patientManager;
        this.appointmentManager = appointmentManager;
    }

    @Override
    public List<String> getAvailableTimeSlots(String speciality) throws NoAvailableTimeSlot {
        List<String> displayData = new ArrayList<>();
        StringBuilder displayString= new StringBuilder();
        Collection<TimeSlot> timeSlots = new ArrayList<>();
        for (Doctor doc : doctorManager.getAllDoctorsOfSpeciality(speciality)) {
            timeSlots = doctorManager.getDoctorAvailability(doc.getName());
            displayString = new StringBuilder(doc.getName() + " : ");
            for (TimeSlot timeSlot : timeSlots) {
                displayString.append(timeSlot.getStartTime()).append(" - ").append(timeSlot.getEndTime()).append(", ");
            }
            displayData.add(displayString.toString());
        }


        return displayData;
    }

    @Override
    public void bookAppointment(String patientName, String doctorName, TimeSlot timeSlot) throws DoctorNotAvailableException, PatientAlreadyHasAppointmentException {
        if(doctorManager.getDoctorAvailabilityForTimeSlot(timeSlot,doctorName)) {
        appointmentManager.addDoctorAppointment(doctorName, patientName, timeSlot);
        doctorManager.removeTimeSlot(timeSlot.getId(),doctorName);
        } else {
            throw new DoctorNotAvailableException();
        }
        if(patientManager.getPatientAvailabilityForTimeSlot(timeSlot,patientName)) {
        appointmentManager.addPatientAppointment(patientName,doctorName,timeSlot);
        patientManager.addTimeSlot(timeSlot,patientName);

        } else {
            throw new PatientAlreadyHasAppointmentException();
        }
    }
}
