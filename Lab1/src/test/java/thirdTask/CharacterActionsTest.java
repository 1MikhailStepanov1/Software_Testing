package thirdTask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Character Actions Test")
public class CharacterActionsTest {

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
    }

    @Test
    public void checkFordLocationChange(){
        String prevLoc = ford.getLocation();
        String newLoc = "У рукояток";
        ford.setLocation(newLoc);
        assertNotEquals(prevLoc, ford.getLocation());
        assertEquals(newLoc, ford.getLocation());
    }

    @Test
    public void checkFordGrabbingKnobs(){
        for (Knob k : ship.getConsole().getKnobs()) {
            ford.grabKnob(k);
        }
        assertEquals(4, ford.getGrabbedKnobs().size());
    }

}
