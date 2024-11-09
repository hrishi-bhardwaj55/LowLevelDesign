package AppointmentStrategy;

import Exceptions.DoctorNotAvailableException;
import Exceptions.NoAvailableTimeSlot;
import Exceptions.PatientAlreadyHasAppointmentException;
import Model.TimeSlot;

import java.util.List;

public interface IAppointmentStrategy {

    public List<String> getAvailableTimeSlots(String speciality) throws NoAvailableTimeSlot;

    void bookAppointment(String patientName, String doctorName, TimeSlot timeSlot) throws DoctorNotAvailableException, PatientAlreadyHasAppointmentException;
}
