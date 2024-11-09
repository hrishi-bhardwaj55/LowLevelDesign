package Strategy;

import Model.ActualInterview;
import Model.Interviewee;
import Model.Interviewer;

import java.util.List;

public interface IAllocationStrategy {
    List<ActualInterview> allocate(List<Interviewer> interviewers, List<Interviewee> interviewees);
}
