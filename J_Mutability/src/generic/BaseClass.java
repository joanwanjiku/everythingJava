package generic;

public class BaseClass {
    public final void recommendedMethod() {
        System.out.println("[BaseClass.recommendedMethod]: Best way to do it");
        optionalMethod();
        mandatoryMethod();
    }

    public void optionalMethod() {
        System.out.println("[BaseClass.optionalMethod]: Optional method");
    }

    private void mandatoryMethod() {
        System.out.println("[BaseClass.mandatoryMethod]: Mandatory method");
    }

    public static void recommendedStatic(){
        System.out.println("[BaseClass.recommendedStatic]: Best way to do it");
        optionalStatic();
        mandatoryStatic();
    }

    private static void mandatoryStatic() {
        System.out.println("[BaseClass.mandatoryStatic]: Mandatory method");
    }

    public static void optionalStatic() {
        System.out.println("[BaseClass.optionalStatic]: Optional method");
    }
}
