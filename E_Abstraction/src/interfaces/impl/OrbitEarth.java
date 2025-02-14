package E_Abstraction.src.interfaces.impl;

import E_Abstraction.src.interfaces.enums.FlightStages;

public interface OrbitEarth extends FlightEnabled{
    String description = null;
    void achieveOrbit();

    static void log(String description) {
        var Date = new java.util.Date();
        System.out.println(Date + ": " + description);
    }

    private void logStage(FlightStages stage, String description) {
        description = stage + " : "+ description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning transistion to " + nextStage);
        return nextStage;
    }
}
