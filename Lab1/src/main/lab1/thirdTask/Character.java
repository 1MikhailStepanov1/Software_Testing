package lab1.thirdTask;


import java.util.ArrayList;
import java.util.List;

public class Character {

    private final String name;

    private final Integer age;

    private String location;

    private List<Knob> grabbedKnobs;

    public Character(String name, int age, String location){
        this.name = name;
        this.age = age;
        this.location = location;
        this.grabbedKnobs = new ArrayList<>();
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return location;
    }

    public void grabKnob(Knob knob){
        grabbedKnobs.add(knob);
    }

    public List<Knob> getGrabbedKnobs(){
        return grabbedKnobs;
    }
}
