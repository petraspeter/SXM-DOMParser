package sk.upjs.ics;

import java.util.*;

public class Rider {
    
    private String firstName;
    private String lastName;
    private String nickName;
    private String type;
    private String dateOfBirth;
    private String nationality;
    private String heightUnit;
    private double height;
    
    private List<SeasonAchievement> seasonAchievements = new ArrayList<>();
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getHeightUnit() {
        return heightUnit;
    }
    
    public void setHeightUnit(String heightUnit) {
        this.heightUnit = heightUnit;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public List<SeasonAchievement> getAchievements() {
        return seasonAchievements;
    }
    
    public void setAchievements(List<SeasonAchievement> achievements) {
        this.seasonAchievements = achievements;
    }

    public Rider(String firstName, String lastName, String nickName, String type, String dateOfBirth, String nationality, String heightUnit, double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.type = type;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.heightUnit = heightUnit;
        this.height = height;
    }
    
    
    
    public String writeRider() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName+" \""+nickName+"\""+" "+lastName+". \nRole: "+type+", date of birth: "+dateOfBirth+", nationality: "+nationality+" "+height+heightUnit+"\n");
        for(SeasonAchievement seasonAchievementa : seasonAchievements) {            
            sb.append("\t"+seasonAchievementa.writeAchievements());
        }     
        return sb.toString();
    }
    
}
