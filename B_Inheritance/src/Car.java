package B_Inheritance.src;

public class Car {
    private String make;
    private String model;
    private String color;
    private int door;
    private boolean covertible;

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getDoor() {
        return door;
    }

    public boolean isCovertible() {
        return covertible;
    }

    public String getMake() {
        return make;
    }


    public void setMake(String make) {
        if (make == null) make = "Unkwokn";
        String lwcaseMake = make.toLowerCase();
        switch (lwcaseMake) {
            case "toyota", "tesla" -> this.make = make;
            default -> this.make = "Unsupported";
        }
    }
    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public void setCovertible(boolean covertible) {
        this.covertible = covertible;
    }
    public void describeCar(){
        System.out.println(make + "make");
    }
}
