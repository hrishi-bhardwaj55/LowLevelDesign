package Model;

public class ActualInterview {

    public Interviewee getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(Interviewee interviewee) {
        this.interviewee = interviewee;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    private Interviewee interviewee;
    private Interviewer interviewer;
    private int slot;
    private String interviewType;

    public ActualInterview(Interviewee interviewee, Interviewer interviewer, int slot, String interviewType) {
        this.interviewee = interviewee;
        this.interviewer = interviewer;
        this.slot = slot;
        this.interviewType = interviewType;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public String toString() {
        //c1_PSDS
        return interviewee.getName() +"_" + interviewType;
    }

    public String displayString() {
        String scheduled = " Could not schedule interview";
        if(interviewer==null) {
            return interviewee.getName() + " " + scheduled + interviewType;
        } else {
            return interviewee.getName() + " " + interviewer.getName() + " " + interviewType + " " + slot;
        }

    }

}
