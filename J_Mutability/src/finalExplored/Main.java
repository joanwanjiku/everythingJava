package finalExplored;

import external.util.Logger;
import generic.BaseClass;
import generic.consumer.specific.ChildClass;

public class Main {
    public static void main(String[] args) {
        BaseClass parent = new BaseClass();
        ChildClass childClass = new ChildClass();
        BaseClass childRefToABaseClass = new ChildClass();

        parent.recommendedMethod();
        System.out.println("-----------------");
        childRefToABaseClass.recommendedMethod();
        System.out.println("-----------------");
        childClass.recommendedMethod();

        System.out.println("-----------------------------------------------");
        parent.recommendedStatic();
        System.out.println("-----------------");
        childRefToABaseClass.recommendedStatic();
        System.out.println("-----------------");
        childClass.recommendedStatic();

        System.out.println("-----------------------------------------------");
        BaseClass.recommendedStatic();
        ChildClass.recommendedStatic();

        System.out.println("-----------------------------------------------");
        String xArguement = "This is a string in the section ";
        StringBuilder zArguement = new StringBuilder("Only this section: section ");
        doXYZ(xArguement, 16, zArguement);
        System.out.println("After Method, xArguement = " + xArguement); // remains the same
        System.out.println("After Method, zArguement = " + zArguement);

        System.out.println("-----------------------------------------------");
        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.log(tracker.toString());
        tracker.append(" and step 2 is xyz");
        Logger.log(tracker.toString());
        System.out.println("After Method, tracker = " + tracker);
    }
    private static void doXYZ(String x, int y, StringBuilder z) {
        final String c = x + y; //
        System.out.println("c = " + c);
        z.append(y);
    }
}
