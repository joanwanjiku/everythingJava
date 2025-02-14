package F_Generics.src.genericsChallenge;

import java.util.Arrays;

public abstract class Line implements Mappable{
    private double[][] location;

    public Line(String... location){
        this.location = new double[location.length][];
        int index = 0;
        for (var coord : location) {
            this.location[index++] = Mappable.stringToLatLon(coord);
        }
    }
    private String location(){
        return Arrays.toString(location);
    }
    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT ("+ location() + ")");
    }
}
