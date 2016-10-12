package sk.upjs.ics;

import java.util.*;

public class SeasonAchievement {
    
    private int year;
    private String team;
    
    private List<Achievement> achievements = new ArrayList<>();
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getTeam() {
        return team;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public List<Achievement> getAchievements() {
        return achievements;
    }
    
    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }
    
    public String writeAchievements() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t"+"Season "+year+", "+team+"\n");
        for (Achievement achievement : achievements) {
            sb.append(achievement.toString()+"\n");
        }
        return sb.toString();
    }
    
}
