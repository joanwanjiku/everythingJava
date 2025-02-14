package E_Abstraction.src.abs;

public class Dog extends Animal{
    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void makeSound() {
        if (type == "Wolf") {
            System.out.println(getType() +" howling");
        } else {
            System.out.println(getType() +" barking");
        }
    }

    @Override
    public void move(String speed) {
        System.out.println(getType()+" Running at " + speed);
    }
}
