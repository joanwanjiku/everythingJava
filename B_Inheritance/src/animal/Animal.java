package B_Inheritance.src.animal;

public class Animal {
    private String type;
    private String size;
    private double weight;

    public  Animal(String type, String size, double weight){
        this.type = type;
        this.size = size;
        this.weight = weight;
    }
    public Animal(){}
    public String getName() {
        return type;
    }

    public void setName(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void move(String speed){
        System.out.println(type + " moves " + speed);
    }
    public void makenoise(){
        System.out.println(type + " eats ");
    }

    @Override
    public String toString() {
        return "Inheritance.src.animal.Animal{" +
                "name='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }
}
