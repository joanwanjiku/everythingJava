package C_Polymorphism.src.polymorphism.vehicle;

public class GasPoweredCar extends Car{
    private double avgKmPerLitre;
    private int cylinders;
    public GasPoweredCar(String desc, double avgKmPerLitre) {
        super(desc);
        this.cylinders = 4;
        this.avgKmPerLitre = avgKmPerLitre;
    }

    @Override
    public void startEngine(){
        System.out.println("starting gas engine---");
    }



}
