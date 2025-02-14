package E_Abstraction.src.interfaces;

import E_Abstraction.src.interfaces.enums.FlightStages;
import E_Abstraction.src.interfaces.impl.FlightEnabled;
import E_Abstraction.src.interfaces.impl.OrbitEarth;
import E_Abstraction.src.interfaces.impl.Trackable;

public class Test {
    public static void main(String[] args) {
//        inFlight(new Jet());
//        OrbitEarth.log("testing");
        orbit(new Satelite());
    }
    public static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.transition(FlightStages.TAKEOFF);
        flier.fly();
        if (flier instanceof Trackable trackable){
            trackable.track();
        }
        flier.land();
    }
    public static void orbit(OrbitEarth flier) {
        flier.takeOff();
        flier.fly();

        flier.land();
    }
}
