package E_Abstraction.src.interfaceChallenge;

import E_Abstraction.src.interfaceChallenge.enums.Color;
import E_Abstraction.src.interfaceChallenge.enums.Geometry;
import E_Abstraction.src.interfaceChallenge.enums.LineMaker;
import E_Abstraction.src.interfaceChallenge.enums.UtilityType;
import E_Abstraction.src.interfaceChallenge.impl.Mappable;

public class UtilityLine implements Mappable {
    private String name;
    private UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }
    public String getLabel() {

        return name + " (" + type+ ")";
    }

    @Override
    public String getMarker() {
        return switch (type) {
            case ELECTRICITY -> Color.RED + " "+ LineMaker.DASHED;
            case FIBRE -> Color.GREEN + " "+ LineMaker.DOTTED;
            case GAS -> Color.BLUE + " "+ LineMaker.SOLID;
            case WATER_SUPPLY -> Color.YELLOW + " "+ LineMaker.SOLID;
            default -> Color.BLACK + " "+ LineMaker.SOLID;
        };
    }

    @Override
    public Geometry getShape() {

        return Geometry.LINE;
    }
    @Override
    public String toJson() {
        return Mappable.super.toJson() + """
                    "name": "%s",
                    "usage": "%s",
            }""".formatted(name, type);
    }
}
