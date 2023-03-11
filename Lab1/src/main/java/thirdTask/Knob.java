package thirdTask;

public class Knob {
    private String purpose;

    private boolean isActivate;

    public Knob(String purpose) {
        this.purpose = purpose;
        this.isActivate = false;
    }

    public void setActivate(boolean activate) {
        isActivate = activate;
    }

    public boolean isActivatedKnob(){
        return isActivate;
    }

}
