package generic.consumer.specific;

import generic.BaseClass;

public class ChildClass extends BaseClass {

    @Override
    public void optionalMethod() {
        System.out.println("[ChildClass.optionalMethod]: Extra Stuff");
        super.optionalMethod();
    }

//    @Override
//    public void recommendedMethod() {
//        System.out.println("[ChildClass.recommendedMethod]: Do things my way");
//        optionalMethod();
//    }

    public static void recommendedStatic(){ // hiding a static method
        System.out.println("[Child.recommendedStatic]: Best way to do it");
        optionalStatic();
//        mandatoryStatic();
    }
}
