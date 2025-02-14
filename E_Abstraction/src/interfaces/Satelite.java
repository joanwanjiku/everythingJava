package E_Abstraction.src.interfaces;

import E_Abstraction.src.interfaces.enums.FlightStages;
import E_Abstraction.src.interfaces.impl.OrbitEarth;

public class Satelite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUND;
    public void achieveOrbit() {
        System.out.println(getClass().getSimpleName() + " is achieving orbit");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("flying");
    }

    @Override
    public void land() {
        transition("landing");
    }

    @Override
    public void takeOff() {
        transition("taking off");
    }
    public void transition(String description) {
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}
