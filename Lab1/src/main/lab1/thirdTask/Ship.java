package lab1.thirdTask;


import java.util.List;

public class Ship {
    private List<Engine> engines;
    private Console console;

    private Direction direction;

    private ShipStatus status;

    public Ship(List<Engine> engines, Console console, Direction direction) {
        this.engines = engines;
        this.console = console;
        this.direction = direction;
        this.status = ShipStatus.NORMAL;
    }

    public void start() {
        for (Engine engine : engines) {
            engine.start();
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Console getConsole() {
        return console;
    }

    public void setStatus(ShipStatus status) {
        this.status = status;
    }

    public ShipStatus getStatus(){
        return status;
    }

    public List<Engine> getEngines(){
        return engines;
    }
}