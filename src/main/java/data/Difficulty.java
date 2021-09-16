package data;

import java.io.Serializable;

public enum Difficulty implements Serializable {
    VERY_EASY,
    NORMAL,
    HARD,
    HOPELESS,
    TERRIBLE;

    public static String nameList() {
        String nameList = "";
        for (Difficulty difficulty : values()) {
            nameList += difficulty.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
