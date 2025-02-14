package E_Abstraction.src.interfaces;

import E_Abstraction.src.interfaces.impl.FlightEnabled;
import E_Abstraction.src.interfaces.impl.Trackable;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;


        inFlight(flier);
        inFlight((new Jet()));

        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("Distance traveled: %.2f km or %.2f miles %n", kmsTraveled, milesTraveled);
    }
    public static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable trackable){
            trackable.track();
        }
        flier.land();
    }
}
