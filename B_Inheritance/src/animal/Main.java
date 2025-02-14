package B_Inheritance.src.animal;

public class Main {
    public static void main(String[] args) {
//                Inheritance
        Animal animal = new Animal("Generic an", "Huge", 400);
        doAnimalStuff(animal, "slow");

        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");

        Dog yorkie = new Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");

        Dog retriever = new Dog("Retriever", 65, "floppy", "swimmer");
        doAnimalStuff(retriever, "slow");
    }
        public static void doAnimalStuff(B_Inheritance.src.animal.Animal animal, String speed){
        animal.move(speed);
        animal.makenoise();
        System.out.println(animal);
        System.out.println("----");
    }
}
