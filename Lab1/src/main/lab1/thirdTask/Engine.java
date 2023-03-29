package lab1.thirdTask;


public class Engine {

    private WorkStatus status;

    private Direction direction;

    public Engine(Direction direction){
        this.direction = direction;
        this.status = WorkStatus.STOPPED;
    }
    public void start() {
        this.status = WorkStatus.IN_PROCESS;
    }

    public void stop(){
        this.status = WorkStatus.STOPPED;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }
}