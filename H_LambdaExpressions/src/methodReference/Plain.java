package methodReference;

public class Plain {
    private static int last_id = 1;
    private int id;
    public Plain() {
        id = last_id++;
        System.out.println("Plain id: " + id);
    }
}
