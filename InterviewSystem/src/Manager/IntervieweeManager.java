package Manager;

import Model.Interviewee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntervieweeManager {

    private Map<String, Interviewee> intervieweeMap;

    public IntervieweeManager() {
        intervieweeMap = new HashMap<>();
    }

    public void add(Interviewee interviewee) {
        intervieweeMap.put(interviewee.getName(), interviewee);
    }

    public List<Interviewee> getInterviewees() {
        return new ArrayList<>(intervieweeMap.values());
    }

    public Map<String, Interviewee> getIntervieweeMap() {
        return intervieweeMap;
    }
}
