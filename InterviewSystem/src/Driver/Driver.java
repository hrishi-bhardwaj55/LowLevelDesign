package Driver;

import Manager.ActualInterviewManager;
import Manager.IntervieweeManager;
import Manager.InterviewerManager;
import Model.Interviewee;
import Model.Interviewer;
import Service.IAllocationService;
import Strategy.IAllocationStrategy;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    ActualInterviewManager actualInterviewManager;
    InterviewerManager interviewerManager;
    IntervieweeManager intervieweeManager;
    IAllocationService allocationService;

    public Driver(ActualInterviewManager actualInterviewManager, InterviewerManager interviewerManager, IntervieweeManager intervieweeManager, IAllocationService allocationService) {
        this.actualInterviewManager = actualInterviewManager;
        this.interviewerManager = interviewerManager;
        this.intervieweeManager = intervieweeManager;
        this.allocationService = allocationService;
    }

    public void addInterviewer(String name, int age, String interviewType, String slots) {
        List<String> interviewTypes = List.of(interviewType.split("_"));
        String[] slotArr = slots.split(",");
        List<Integer> slotList = new ArrayList<>();
        for(String s : slotArr) {
            slotList.add(Integer.parseInt(s));
        }
        Interviewer interviewer = new Interviewer(name,age,interviewTypes,slotList);
        interviewerManager.addInterviewer(interviewer);
        System.out.println("Interviewer added");
    }

    public void addInterviewee(String name, String slots) {
        String[] slotArr = slots.split(",");
        List<Integer> slotList = new ArrayList<>();
        for(String s : slotArr) {
            slotList.add(Integer.parseInt(s));
        }
        Interviewee interviewee = new Interviewee(name,slotList);
        intervieweeManager.add(interviewee);
        System.out.println("Interviewee added");
    }

    public void allocate() {
        allocationService.allocateInterviews();
    }

    public void showALlocations() {
        allocationService.showInterviews();
    }
}
