package E_Abstraction.src.abs;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("wolf", "big", 100);
        Dog do2g = new Dog("Poddle", "small", 80);
//        Inheritance.src.animal.Animal cat = new Cat();
//        testAnimal(dog);

        Cat cat = new Cat("male", "small", 50);
        Cat cat2 = new Cat("female", "small", 47);
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);
        animals.add(do2g);
        animals.add(cat2);
        for (Animal anAnimal : animals) {
            testAnimal(anAnimal);
        }
    }
    public static void testAnimal(Animal animal) {
        animal.makeSound();
        animal.move("fast");
    }
}
