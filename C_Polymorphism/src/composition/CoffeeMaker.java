package C_Polymorphism.src.composition;

public class CoffeeMaker {
    private boolean hasWorkToDo;

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public boolean brewCoffee(){
        if (hasWorkToDo){
            System.out.println("Coffee brewed successfully");
            return true;
        }
        return false;
    }
}
