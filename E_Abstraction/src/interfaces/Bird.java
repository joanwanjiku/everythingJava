package E_Abstraction.src.interfaces;

import E_Abstraction.src.interfaces.impl.FlightEnabled;
import E_Abstraction.src.interfaces.impl.Trackable;

public class Bird extends Animal implements FlightEnabled, Trackable {
    @Override
    public void move() {
        System.out.println("Bird is flying");
    }

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
}
