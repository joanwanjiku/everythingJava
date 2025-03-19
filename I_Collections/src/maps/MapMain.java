package maps;

import sets.Contact;
import sets.ContactData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-----------------------------------------------------");

        Map<String, Contact> contactMap = new HashMap<>();
        for (Contact contact : fullList) {
            contactMap.put(contact.getName(), contact);
        }
        contactMap.forEach((k, v) -> System.out.println("Key= "+ k + " Value= "+ v));
//        get
        System.out.println("Contact with name 'Daffy Duck' is: " + contactMap.get("Daffy Duck"));
        System.out.println("------------------------------------------------------");

        contactMap.clear();
        System.out.println("Contact Map after clear: " + contactMap);
        System.out.println("------------------------------------------------------");
        for (Contact cont: fullList) {
            Contact dup = contactMap.put(cont.getName(), cont);
            if (dup != null){
//                System.out.println("Duplicate contact found: " + dup);
                contactMap.put(cont.getName(), cont.mergeContact(dup));
            }
        }
        contactMap.forEach((k, v) -> System.out.println("Key= "+ k + " Value= "+ v));
        System.out.println("------------------------------------------------------");
        contactMap.clear();
        for (Contact cont: fullList) {
            contactMap.putIfAbsent(cont.getName(), cont);
        }
        contactMap.forEach((k, v) -> System.out.println("Key= "+ k + " Value= "+ v));
        System.out.println("Merge method------------------------------------------------------");
        contactMap.clear();
        fullList.forEach(contact -> contactMap.merge(contact.getName(), contact,
                Contact::mergeContact
                ));
        contactMap.forEach((k, v) -> System.out.println("Key= "+ k + " Value= "+ v));

//
    }
}
