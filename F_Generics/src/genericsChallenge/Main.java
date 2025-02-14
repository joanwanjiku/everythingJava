package F_Generics.src.genericsChallenge;

public class Main {
    public static void main(String[] args) {


        var nationalParks = new Park[]{
            new Park("Acadia National Park", "44.4888, -110.384"),
            new Park("Arches National Park", "46.373, -112.439"),
            new Park("Badlands National Park", "37.843, -594.9292")
        };

        Layer<Park> parkLayer = new Layer<>(nationalParks);
        parkLayer.renderLayer();

        var rivers = new River[]{
            new River("Mississippi River", "38.4589, -90.278", "73.383, -882.22"),
            new River("Missouri River", "38.3485, -92.2895", "70.393, -114.3003"),
            new River("Nile River", "24.8607, 32.8541","36.992, -98.393")
        };
        Layer<River> riverLayer = new Layer<>(rivers);
        riverLayer.addElements(new River("Colorado", "63.392, -22.292"));
        riverLayer.renderLayer();


    }
}
