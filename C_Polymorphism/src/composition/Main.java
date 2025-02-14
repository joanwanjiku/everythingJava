package C_Polymorphism.src.composition;

public class Main {
    public static void main(String[] args) {
        SmartKitchen smartKitchen = new SmartKitchen(new CoffeeMaker(), new DishWasher(), new Refrigerator());


        smartKitchen.setKitchenState(true, false, true);

        smartKitchen.doWork();
    }
}
