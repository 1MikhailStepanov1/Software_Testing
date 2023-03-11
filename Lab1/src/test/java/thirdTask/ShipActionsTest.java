package thirdTask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Ship Actions Test")
public class ShipActionsTest {
    private Ship ship;

    private Character ford;

    @BeforeEach
    public void setUp(){
        Engine engine1 = new Engine(Direction.W_90);
        Engine engine2 = new Engine(Direction.W_90);
        Engine engine3 = new Engine(Direction.W_90);
        Engine engine4 = new Engine(Direction.W_90);
        List<Engine> engines = new ArrayList<>();
        engines.add(engine1);
        engines.add(engine2);
        engines.add(engine3);
        engines.add(engine4);

        Knob knob1 = new Knob("Давление");
        Knob knob2 = new Knob("Шасси");
        Knob knob3 = new Knob("Люк");
        Knob knob4 = new Knob("Фары");
        List<Knob> knobs = new ArrayList<>();
        knobs.add(knob1);
        knobs.add(knob2);
        knobs.add(knob3);
        knobs.add(knob4);
        Console console = new Console(knobs);

        ship = new Ship(engines, console, Direction.W_90);
        ford = new Character("Форд", 33, "В центре отсека управления кораблем");
        ship.start();

        Rocket rocket1 = new Rocket();
        Rocket rocket2 = new Rocket();
        rocket1.launch(Direction.W_90);
        rocket2.launch(Direction.W_90);
    }

    private void setShipStatus(){
        Direction tempDir = ship.getEngines().get(0).getDirection();
        for (Engine e : ship.getEngines()){
            if (e.getDirection() != tempDir) {
                ship.setStatus(ShipStatus.SHAKING);
            }
        }
    }

    private void activateKnobs(int amount){
        for (int i = 0; i < amount; i++){
            ford.grabKnob(ship.getConsole().getKnobs().get(i));
        }
        for (Knob kn : ford.getGrabbedKnobs()){
            kn.setActivate(true);
        }
        int count  = 0;
        for (Knob k : ship.getConsole().getKnobs()){
            if (k.isActivatedKnob()){
                count++;
            }
        }
        if (count >= 2) {
            ship.setDirection(Direction.E_270);
        }
    }

    private void deactivateKnobs(){
        for (Knob kn : ford.getGrabbedKnobs()){
            kn.setActivate(false);
        }
    }

    @Test
    public void checkShipStatus(){
        setShipStatus();
        assertEquals(ShipStatus.NORMAL, ship.getStatus());

        ship.getEngines().get(1).setDirection(Direction.N_180);
        ship.getEngines().get(2).setDirection(Direction.E_270);
        ship.getEngines().get(3).setDirection(Direction.S_360);

        setShipStatus();
        assertNotEquals(ShipStatus.NORMAL, ship.getStatus());
    }

    @Test
    public void checkShipDirection(){
        activateKnobs(1);
        assertEquals(Direction.W_90, ship.getDirection());
        deactivateKnobs();

        activateKnobs(3);
        assertNotEquals(Direction.W_90, ship.getDirection());
        assertEquals(Direction.E_270, ship.getDirection());
    }
}
