package E_Abstraction.src.interfaceChallenge;

import E_Abstraction.src.interfaceChallenge.Building;
import E_Abstraction.src.interfaceChallenge.enums.UsageType;
import E_Abstraction.src.interfaceChallenge.enums.UtilityType;
import E_Abstraction.src.interfaceChallenge.impl.Mappable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Mappable> mappableList = new ArrayList<>();

        mappableList.add(new Building("Town hall", UsageType.GOVERNMENT));
        mappableList.add(new Building("Opera hall", UsageType.ENTERTAINMENT));
        mappableList.add(new Building("Staduim hall", UsageType.SPORTS));
        mappableList.add(new UtilityLine("Electricity line", UtilityType.ELECTRICITY));
        mappableList.add(new UtilityLine("Fibre line", UtilityType.FIBRE));

        for (Mappable mappable : mappableList) {
            Mappable.mappableMeth(mappable);
//            System.out.println(mappable.getLabel());
        }

    }
}
