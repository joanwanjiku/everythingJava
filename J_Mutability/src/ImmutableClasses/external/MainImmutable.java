package ImmutableClasses.external;

import ImmutableClasses.Person;
import ImmutableClasses.PersonImmutable;

import java.util.Arrays;

public class MainImmutable {
    public static void main(String[] args) {
        PersonImmutable jane = new PersonImmutable("Jane", "05/05/1995");
        PersonImmutable Bob = new PersonImmutable("Bob", "06/06/1996");
        PersonImmutable johnParent = new PersonImmutable("John", "01/01/1970", new PersonImmutable[]{jane, Bob});


        System.out.println(Arrays.toString(johnParent.getKids()));

        LivingPerson johnLiving = new LivingPerson(johnParent.getName(), johnParent.getKids());
        System.out.println(johnLiving);
        LivingPerson ann = new LivingPerson("Ann", null);
        johnLiving.addKid(ann);
        System.out.println(johnLiving);
        System.out.println("------------------");

    }
}
