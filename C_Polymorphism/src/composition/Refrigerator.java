package C_Polymorphism.src.composition;

public class Refrigerator {
    private boolean hasWorkToDo;

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public boolean orderFood(){
        if (hasWorkToDo){
            System.out.println("Refrigerator ordering food");
            return true;
        }
        return false;
    }
}
