package E_Abstraction.src.interfaces;

import E_Abstraction.src.interfaces.enums.FlightStages;
import E_Abstraction.src.interfaces.impl.FlightEnabled;
import E_Abstraction.src.interfaces.impl.Trackable;

public class Jet implements FlightEnabled, Trackable {
    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " is landing");
    }

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + " is being tracked");
    }

    @Override
    public FlightStages transition(FlightStages stage) {
        System.out.println(getClass().getSimpleName() + " Transitioning");
        return FlightEnabled.super.transition(stage);
    }
}
