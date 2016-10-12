package sk.upjs.ics;

import java.util.*;

public class Achievement {
    
    private String raceType;
    private String achievement;

    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    @Override
    public String toString() {
        return "\t\t\t\t"+raceType + " achievement: " + achievement;
    }
    
}
