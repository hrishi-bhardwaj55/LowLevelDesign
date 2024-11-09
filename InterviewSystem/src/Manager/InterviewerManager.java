package Manager;

import Model.Interviewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewerManager {

    private Map<String, Interviewer> interviewerMap = new HashMap<>();

    public List<Interviewer> getInterviewers() {
        return new ArrayList<>(interviewerMap.values());
    }

    public void addInterviewer(Interviewer interviewer) {
        interviewerMap.put(interviewer.getName(), interviewer);
    }

    public Map<String, Interviewer> getInterviewerMap() {
        return interviewerMap;
    }
}
