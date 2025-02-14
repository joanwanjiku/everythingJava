package E_Abstraction.src.interfaceChallenge.impl;

import E_Abstraction.src.interfaceChallenge.enums.Geometry;

public interface Mappable {
    String JSON_PROPERTY = """
            "properties": {%s}""";
    String getLabel();
    String getMarker();
    Geometry getShape();

    static void mappableMeth(Mappable map){
        System.out.printf((JSON_PROPERTY) + "%n", (map.toJson()));
    }
    default String toJson(){
        return """
                
                    "type": "%s",
                    "label": "%s",
                    "marker": "%s"
            """.formatted(getShape(), getLabel(), getMarker());

    }

}
