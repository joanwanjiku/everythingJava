package F_Generics.src.genericsChallenge;

public class Park extends Point{
    private String name;

    public Park(String name, String location) {
        super(location);
        this.name = name;
    }

    @Override
    public String toString() {
        return name+ " Park";
    }

}
