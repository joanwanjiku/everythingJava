package D_ArrayLists.src;

import java.util.ArrayList;

public class MobilePhone {
    // write code here
    private ArrayList<Contact> myContacts;
    private String myNumber;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) > 0){
            System.out.println("Contact already exists.");
            return false;
        }
        return myContacts.add(contact);
    }
    public boolean updateContact(Contact contact, Contact newContact) {
        if (myContacts.contains(contact)){
            myContacts.remove(contact);
            myContacts.add(newContact);
            return true;
        }
        return false;
    }
    public boolean removeContact(Contact contact) {
        return myContacts.remove(contact);
    }
    public int findContact(Contact contact){
        return (myContacts.contains(contact))? myContacts.indexOf(contact): -1;
    }
    public int findContact(String num){
        for (Contact contact : myContacts) {
            if (contact.getPhoneNumber().equals(num)) {
                return myContacts.indexOf(contact);
            }
        }
        return -1;
    }
    public Contact queryContact(String name) {
        for (Contact contact : myContacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }
    public void printContacts(){
        for (Contact contact: myContacts) {
            System.out.println("Contact List: " + contact.getName() + " -> "+ contact.getPhoneNumber()+
                    "");

        }
    }
}