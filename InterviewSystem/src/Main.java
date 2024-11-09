import Driver.Driver;
import Manager.ActualInterviewManager;
import Manager.IntervieweeManager;
import Manager.InterviewerManager;
import Model.Interviewer;
import Service.DefaultAllocationService;
import Service.IAllocationService;
import Strategy.DefaultAllocationStrategy;
import Strategy.IAllocationStrategy;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ActualInterviewManager actualInterviewManager = new ActualInterviewManager();
        IntervieweeManager intervieweeManager = new IntervieweeManager();
        InterviewerManager interviewerManager = new InterviewerManager();
        IAllocationStrategy allocationStrategy = new DefaultAllocationStrategy();
        IAllocationService allocationService = new DefaultAllocationService(actualInterviewManager,interviewerManager,intervieweeManager,allocationStrategy);

        Driver driver = new Driver(actualInterviewManager,interviewerManager,intervieweeManager,allocationService);

//        driver.addInterviewer("A1",50,"PSDS_MachineCoding","1,2,3");
//        driver.addInterviewee("C1","2,3,4,5,6");

        driver.addInterviewer("In1",7,"PSDS_MachineCoding","1,2,3,4");
        driver.addInterviewer("In2",7,"PSDS_MachineCoding","2,3,4");
        driver.addInterviewee("C1","1,2,3,7,8");
        driver.addInterviewee("C2","1,2,3,7,8");
        driver.addInterviewee("C3","1,2,3,7,8");
        driver.allocate();
        driver.showALlocations();
    }
}