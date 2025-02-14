package C_Polymorphism.src.polymorphism.vehicle;

public class HybridCar extends Car{
    private double avgKmPerLitre;
    private int cylinders;
    private int batterySize;
    public HybridCar(String desc) {
        super(desc);
    }

    @Override
    public void startEngine(){
        System.out.println("starting hybrid engine---");
    }
}
