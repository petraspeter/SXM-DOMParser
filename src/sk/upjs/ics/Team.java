package sk.upjs.ics;

import java.util.*;
import sk.upjs.ics.Rider;

public class Team {
    
    private String teamName;
    
    private List<Rider> riders = new ArrayList<>();

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public void setRiders(List<Rider> riders) {
        this.riders = riders;
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }
    
    public String writeTeam() {
        StringBuilder sb = new StringBuilder();
        sb.append(teamName+": \n");
        for(Rider rider : riders) {
            sb.append(rider.writeRider());
        }
        return sb.toString();
    }
    
}
