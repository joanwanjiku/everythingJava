package E_Abstraction.src.abs;

public class Cat extends Animal{
    public Cat(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void makeSound() {
        if (type == "male") {
            System.out.println(getType() +" Meow!");
        } else {
            System.out.println(getType() +" Hissing");
        }
    }

    @Override
    public void move(String speed) {
        System.out.println(getType()+" cat walking at " + speed);
    }
}
