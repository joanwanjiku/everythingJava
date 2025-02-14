package F_Generics.src.genericsChallenge;

public interface Mappable {

    void render();

    static  double[] stringToLatLon(String coords) {
        var splits = coords.split(",");
        double lat = Double.valueOf(splits[0]);
        double lng = Double.valueOf(splits[1]);
        return new double[] {lat, lng};
    }
}
