package F_Generics.src.genericsChallenge;

public class River extends Line{
    String name;
    public River(String name, String... location) {
        super(location);
        this.name = name;
    }
    @Override
    public String toString() {
        return name + " River";
    }
}
