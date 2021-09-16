package data;

import java.io.Serializable;

public enum Color implements Serializable {
    GREEN,
    RED,
    ORANGE,
    BROWN;

    public static String nameList() {
        String nameList = "";
        for (Color  eyeColor : values()) {
            nameList += eyeColor.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
