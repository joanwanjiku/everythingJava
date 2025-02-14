package C_Polymorphism.src.polymorphism.vehicle;

public class Car {
    private String desc;

    public Car(String desc) {
        this.desc = desc;
    }

    public void startEngine(){
        System.out.println("starting---");
    }
    public void drive(){
        System.out.println("driving---");
    }
    protected void runEngine(){
        System.out.println("running Engine---");
    }
}
