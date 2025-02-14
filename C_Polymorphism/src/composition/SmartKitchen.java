package C_Polymorphism.src.composition;

public class SmartKitchen {
    private CoffeeMaker coffeeMaker;
    private DishWasher dishWasher;

    private Refrigerator icebox;

    public SmartKitchen(CoffeeMaker coffeeMaker, DishWasher dishWasher, Refrigerator icebox) {
        this.coffeeMaker = coffeeMaker;
        this.dishWasher = dishWasher;
        this.icebox = icebox;
    }
    public SmartKitchen(){}

    public void setKitchenState(boolean coffeeMker, boolean dshWasher, boolean icebx){
        coffeeMaker.setHasWorkToDo(coffeeMker);
        dishWasher.setHasWorkToDo(dshWasher);
        icebox.setHasWorkToDo(icebx);
    }
    public void doWork(){
        coffeeMaker.brewCoffee();
        dishWasher.doDishes();
        icebox.orderFood();
    }
}
