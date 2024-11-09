package Manager;

import Model.ActualInterview;

import java.util.*;

public class ActualInterviewManager {

    private Map<String, ActualInterview> interviewMap = new TreeMap<>();

    public ActualInterview getInterview(String id) {
        return interviewMap.get(id);
    }

    public void addInterview(ActualInterview interview) {
        interviewMap.put(interview.toString(),interview);
    }

    public List<ActualInterview> getAllInterviews() {
//        Arrays.sort();
//        List<ActualInterview> list = new ArrayList<>(interviewMap.values());


        return new ArrayList<>(interviewMap.values());
    }

}
