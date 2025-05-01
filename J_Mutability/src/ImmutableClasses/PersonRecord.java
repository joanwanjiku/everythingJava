package ImmutableClasses;

import java.util.Arrays;

public record PersonRecord(String name, String dob, PersonRecord[] kids) {
    public PersonRecord(String name, String dob) {
        this(name, dob, new PersonRecord[20]);
    }
    @Override
    public String toString() {
        String kidString = "n/a";
        if (kids != null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] =kids[i] == null ? "n/a" : kids[i].name());
            kidString = Arrays.toString(names);
        }
        return name + ", dob"+ dob+ ", kids" + kidString;
    }
}
