package Model;

import java.util.ArrayList;
import java.util.List;

public class Interviewer {
    private String name;
    private int age;
    private List<String> interviewType = new ArrayList<>();

    public Interviewer(String name, int age, List<String> interviewType, List<Integer> slots) {
        this.name = name;
        this.age = age;
        this.interviewType = interviewType;
        this.slots = slots;
    }

    public List<Integer> getSlots() {
        return slots;
    }

    public void setSlots(List<Integer> slots) {
        this.slots = slots;
    }

    public List<String> getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(List<String> interviewType) {
        this.interviewType = interviewType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Integer> slots = new ArrayList<>();
}
