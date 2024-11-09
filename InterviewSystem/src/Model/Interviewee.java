package Model;

import java.util.ArrayList;
import java.util.List;

public class Interviewee {
    private String name;
    private List<Integer> slot = new ArrayList<Integer>();

    public Interviewee(String name, List<Integer> slot) {
        this.name = name;
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getSlot() {
        return slot;
    }

    public void setSlot(List<Integer> slot) {
        this.slot = slot;
    }
}
