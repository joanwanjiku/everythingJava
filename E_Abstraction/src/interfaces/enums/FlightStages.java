package E_Abstraction.src.interfaces.enums;

import E_Abstraction.src.interfaces.impl.Trackable;

public enum FlightStages implements Trackable {
    GROUND,
    TAKEOFF,
    IN_AIR,
    LANDING;

    @Override
    public void track() {
        if (this != GROUND){
            System.out.println(getClass().getSimpleName() + " is being monitored");
        }
    }
    public FlightStages getNextStage() {
        FlightStages[] allStages = values();

        return allStages[(ordinal() + 1) % allStages.length];
    }
}
