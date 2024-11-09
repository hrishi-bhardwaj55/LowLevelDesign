import AppointmentStrategy.DefaultAppointmentStrategy;
import AppointmentStrategy.IAppointmentStrategy;
import Exceptions.DoctorNotAvailableException;
import Exceptions.NoAvailableTimeSlot;
import Exceptions.PatientAlreadyHasAppointmentException;
import Managers.AppointmentManager;
import Managers.DoctorManager;
import Managers.PatientManager;
import Model.Doctor;
import Model.Patient;
import Model.TimeSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws NoAvailableTimeSlot {

        DoctorManager doctorManager = new DoctorManager();
        PatientManager patientManager = new PatientManager();
        AppointmentManager appointmentManager = new AppointmentManager();
        IAppointmentStrategy appointmentStrategy = new DefaultAppointmentStrategy(doctorManager, patientManager, appointmentManager);

        Scanner sc = new Scanner(System.in);
        boolean continueLoop = true;

        try {
            while (continueLoop) {
                String input = sc.nextLine();
                String[] inputArray = input.split(" ");
                String[] timeslots;
                List<TimeSlot>timeslotList = new ArrayList<>();
                switch (inputArray[0]) {
                    case "addDoctor":
                        // addDoctor name speciality 9-10,10-11,15-16
                        timeslots = inputArray[inputArray.length - 1].split(",");
                        for(String ts: timeslots) {
                            String[] timeArray = ts.split("-");
                            timeslotList.add(new TimeSlot(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1])));
                        }
                        Doctor doc = new Doctor(inputArray[1],inputArray[2],timeslotList);
                        doctorManager.addDoctor(doc);
                        System.out.println("Doctor added - " + doc.getName());
                        break;
                    case "addPatient":
                        //addPatient name
                        patientManager.addPatient(new Patient(inputArray[1]));
                        System.out.println("Patient added - " + inputArray[1]);
                        break;

                    case "getAvailableTimeslots":
                        //getAvailableTimeslots Cardiologist
                        List<String> availableDoctors = appointmentStrategy.getAvailableTimeSlots(inputArray[1]);
                        for(String str: availableDoctors) {
                            System.out.println(str);
                        }
                        break;
                    case "bookAppointment":
                        //bookAppointment patientName doctorName 9-10
                        timeslots = inputArray[inputArray.length - 1].split("-");
                        appointmentStrategy.bookAppointment(inputArray[1],inputArray[2],new TimeSlot(Integer.parseInt(timeslots[0]),Integer.parseInt(timeslots[1])));
                        break;
                    case "exit":
                        //exit
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Invalid input");

                }
            }
        } catch (Exception | DoctorNotAvailableException | PatientAlreadyHasAppointmentException e) {
            System.out.println(e.getMessage());
        }

    }
}