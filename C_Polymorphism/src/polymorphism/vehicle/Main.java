package C_Polymorphism.src.polymorphism.vehicle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Ford 150");
        runRace(car);
        Car ferrari = new GasPoweredCar("blue ferrari", 15.4);
        runRace(ferrari);
    }
    public static void runRace(Car car){
        System.out.println(car.getClass().getSimpleName() + " is racing");
        car.drive();
        car.startEngine();
    }
}
