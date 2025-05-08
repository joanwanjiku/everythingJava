package constructorsImmutable;

import java.util.Random;

public class Child extends Parent {
    private final int birthOrder = getBirthOrder();
    private final String birthOrderString;
    {
        if (siblings == 0) {
            birthOrderString = "only child";
        } else {
            birthOrderString = "child " + birthOrder + " of " + siblings;
        }
        System.out.println("In child initializer");
    }
    public Child() {
        super("Jane", 6, 5 );
    }
    private final int getBirthOrder(){
        if (siblings == 0) return 1;
        return  new Random().nextInt(1, siblings + 2);
    }
    @Override
    public String toString() {
        return super.toString() + ", " + birthOrderString;
    }

}
