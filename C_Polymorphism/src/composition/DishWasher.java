package C_Polymorphism.src.composition;

public class DishWasher {
    private boolean hasWorkToDo;

    public boolean doDishes(){
        if (hasWorkToDo){
            System.out.println("Dishwasher is washing dishes");
            return true;
        }
        return false;
    }

    public void setHasWorkToDo(boolean b) {
        hasWorkToDo = b;
    }
}
