package E_Abstraction.src.interfaces;

import E_Abstraction.src.interfaces.impl.Trackable;

public class Truck implements Trackable {
    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + " is being tracked");
    }
}
