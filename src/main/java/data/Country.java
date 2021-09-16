package data;

import java.io.Serializable;

public enum Country implements Serializable {
    UNITED_KINGDOM,
    GERMANY,
    SPAIN,
    INDIA,
    THAILAND;

    public static String nameList() {
        String nameList = "";
        for (Country nationality : values()) {
            nameList += nationality.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
