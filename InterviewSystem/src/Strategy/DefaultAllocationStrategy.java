package Strategy;

import Model.ActualInterview;
import Model.Interviewee;
import Model.Interviewer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultAllocationStrategy implements IAllocationStrategy {

    String[] interviewTypes = {"PSDS","MachineCoding"};


    @Override
    public List<ActualInterview> allocate(List<Interviewer> interviewers, List<Interviewee> interviewees) {


        List<ActualInterview> result = new ArrayList<>();
        for(Interviewee interviewee : interviewees) {
            boolean scheduled = false;
            int slot = -1;

            Interviewee finalInterviewee = null;
            String finalInterviewType = "";
            String interviewerName = "";
            int usedSlot = -1;
            for(String interviewTyp : interviewTypes) {
                Interviewer finalInterviewer = null;

                for(Interviewer interviewer : interviewers) {
                    List<Integer> commonSlots = interviewee.getSlot().stream().filter(interviewer.getSlots()::contains).collect(Collectors.toList());
                    if(commonSlots.size()>0 && !interviewerName.equals(interviewer.getName()))
                    {
                        for(int currentSlot : commonSlots) {
                            if(currentSlot != usedSlot) {
                                usedSlot = currentSlot;
                                interviewee.getSlot().remove(interviewee.getSlot().indexOf(currentSlot));
                                interviewer.getSlots().remove(interviewer.getSlots().indexOf(currentSlot));
                                finalInterviewer = interviewer;
                                finalInterviewee = interviewee;
                                finalInterviewType = interviewTyp;
                                interviewerName = interviewer.getName();
                                scheduled = true;
                                break;

                            }
                        }
                        if(scheduled) {
                            break;
                        }
                    }
                }
                if(scheduled){
//                    break;
                } else {
                    finalInterviewee = interviewee;
                    finalInterviewType = interviewTyp;
                }
            ActualInterview actualInterview = new ActualInterview(finalInterviewee,finalInterviewer,usedSlot, interviewTyp );
            result.add(actualInterview);
            }


        }
        return result;
    }
}
