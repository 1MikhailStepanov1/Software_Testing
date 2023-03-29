package lab1.thirdTask;


import java.util.List;

public class Console {
    private List<Knob> knobs;

    public Console(List<Knob> knobs){
        this.knobs = knobs;
    }

    public List<Knob> getKnobs() {
        return knobs;
    }

}