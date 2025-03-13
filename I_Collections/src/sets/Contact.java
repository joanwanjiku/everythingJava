package sets;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contact {
    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();



    public Contact(String name, String email, long phone) {
        this.name = name;
        if (email != null){
            emails.add(email);
        }
        if (phone > 0){
            String p = (String.valueOf(phone));
            p = "(%s) %s-%s".formatted(p.substring(0, 3), p.substring(3, 6), p.substring(6));
            phones.add(p);
        }
    }
    public Contact(String name, long phone){
        this(name, "", phone);
    }
    public Contact(String name, String email){
        this(name, email, 0);
    }
    public Contact(String name){
        this(name, "", 0);
    }

    public String getName() {
        return name;
    }
    public Contact mergeContact(Contact contact) {
        Contact newContact = new Contact(name);
        newContact.emails = new HashSet<>(this.emails);
        newContact.phones = new HashSet<>(this.phones);
        newContact.emails.addAll(contact.emails);
        newContact.phones.addAll(contact.phones);
        return newContact;
    }

    @Override
    public String toString() {
        return "%s: %s %s".formatted(name, emails, phones);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getName(), contact.getName()) &&
                Objects.equals(emails, contact.emails)
                && Objects.equals(phones, contact.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
