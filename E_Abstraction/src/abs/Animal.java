package E_Abstraction.src.abs;

public abstract class Animal {
    protected  String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void makeSound();

    public abstract void move(String speed);
    public String getType(){
        return getClass().getSimpleName() + " ("+type+")";
    }
}
