package E_Abstraction.src.interfaceChallenge;

import E_Abstraction.src.interfaceChallenge.enums.Color;
import E_Abstraction.src.interfaceChallenge.enums.Geometry;
import E_Abstraction.src.interfaceChallenge.enums.PointMaker;
import E_Abstraction.src.interfaceChallenge.enums.UsageType;
import E_Abstraction.src.interfaceChallenge.impl.Mappable;

public class Building implements Mappable {
    private String name;
    private UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }
    @Override
    public String getLabel() {

        return name + " (" + usage+ ")";
    }

    @Override
    public String getMarker() {
        return switch (usage) {
            case ENTERTAINMENT -> Color.GREEN + " "+ PointMaker.TRIANGLE;
            case GOVERNMENT -> Color.RED + " "+ PointMaker.STAR;
            case RESIDENTIAL -> Color.BLUE + " "+ PointMaker.SQUARE;
            case SPORTS -> Color.YELLOW + " "+ PointMaker.PUSH_PIN;
            default -> Color.BLACK + " "+ PointMaker.CIRCLE;
        };
    }

    @Override
    public Geometry getShape() {

        return Geometry.POINT;
    }

    @Override
    public String toJson() {
        return Mappable.super.toJson() + """
                    "name": "%s",
                    "usage": "%s",
            }""".formatted(name, usage);
    }
}
