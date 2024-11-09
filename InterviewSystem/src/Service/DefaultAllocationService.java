package Service;

import Manager.ActualInterviewManager;
import Manager.IntervieweeManager;
import Manager.InterviewerManager;
import Model.ActualInterview;
import Model.Interviewee;
import Model.Interviewer;
import Strategy.IAllocationStrategy;

import java.util.ArrayList;
import java.util.List;

public class DefaultAllocationService implements IAllocationService {
    ActualInterviewManager actualInterviewManager;
    InterviewerManager interviewerManager;
    IntervieweeManager intervieweeManager;
    IAllocationStrategy allocationStrategy;

    public DefaultAllocationService(ActualInterviewManager actualInterviewManager, InterviewerManager interviewerManager, IntervieweeManager intervieweeManager,IAllocationStrategy allocationStrategy) {
        this.actualInterviewManager = actualInterviewManager;
        this.interviewerManager = interviewerManager;
        this.intervieweeManager = intervieweeManager;
        this.allocationStrategy = allocationStrategy;
    }


    @Override
    public void allocateInterviews() {
        List<Interviewer> interviewers = interviewerManager.getInterviewers();
        List<Interviewee> interviewees = intervieweeManager.getInterviewees();
        List<ActualInterview> actualInterviews = allocationStrategy.allocate(interviewers,interviewees);
        for(ActualInterview actualInterview : actualInterviews){
            actualInterviewManager.addInterview(actualInterview);
        }
//        showInterviews();
    }

    @Override
    public void showInterviews() {
        for (ActualInterview actualInterview : actualInterviewManager.getAllInterviews()){
            System.out.println(actualInterview.displayString());
        }
    }

}
