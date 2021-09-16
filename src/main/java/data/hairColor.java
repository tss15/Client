package data;

import java.io.Serializable;

public enum hairColor implements Serializable {
    BLACK,
    YELLOW,
    BROWN;

    public static String nameList() {
        String nameList = "";
        for (hairColor hairColor : values()) {
            nameList += hairColor.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
