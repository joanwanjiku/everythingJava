package E_Abstraction.src.interfaces.impl;

import E_Abstraction.src.interfaces.enums.FlightStages;

public interface FlightEnabled {

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    void fly();
    void land();
    void takeOff();

//    FlightStages transition(FlightStages stage);
    default FlightStages transition(FlightStages stage){
//        System.out.println("Transition not implemented on "+ getClass().getName());
//        return null;
        FlightStages nextStage = stage.getNextStage();
        System.out.println(getClass().getSimpleName() + " transitioning to: " + nextStage + " From "+ stage);
        return nextStage;
    }

}
