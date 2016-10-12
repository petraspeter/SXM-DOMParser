package sk.upjs.ics;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMReader {

	private UCIRoad creatUCIRoad(Element xmlUCIRoad) {
		if (!"UCIRoad".equals(xmlUCIRoad.getNodeName())) {
			throw new RuntimeException("Korenovy element je nekorektny!");
		}

		String category = xmlUCIRoad.getAttribute("category");
		int actualSeason = Integer.parseInt(xmlUCIRoad.getAttribute("actualSeason"));

		UCIRoad uciRoad = new UCIRoad(category, actualSeason);

		NodeList xmlTeams = xmlUCIRoad.getChildNodes();
		for (int i = 0; i < xmlTeams.getLength(); i++) {
			Node xmlTeam = xmlTeams.item(i);
			if ((xmlTeam instanceof Element) && ("worldTeam".equals(xmlTeam.getNodeName()))) {
				Team newTeam = createTeam((Element) xmlTeam);
				uciRoad.getTeams().add(newTeam);
			}
		}
		return uciRoad;
	}

	private Team createTeam(Element xmlTeam) {
		if (!"worldTeam".equals(xmlTeam.getNodeName())) {
			throw new RuntimeException("Element je nekorektny!");
		}

		String teamName = xmlTeam.getAttribute("teamName");
		Team team = new Team(teamName);

		NodeList xmlRiders = xmlTeam.getChildNodes();
		for (int i = 0; i < xmlRiders.getLength(); i++) {
			Node xmlRider = xmlRiders.item(i);
			if ((xmlRider instanceof Element) && ("rider".equals(xmlRider.getNodeName()))) {
				Rider newRider = createRider((Element) xmlRider);
				team.getRiders().add(newRider);
			}
		}
		return team;
	}

	private Rider createRider(Element xmlRider) {
		if (!"rider".equals(xmlRider.getNodeName())) {
			throw new RuntimeException("Element je nekorektny!");
		}
		Rider rider = new Rider();
		rider.setFirstName(vratPodelement(xmlRider, "firstName").getTextContent());
		rider.setLastName(vratPodelement(xmlRider, "lastName").getTextContent());
		rider.setNickName(vratPodelement(xmlRider, "nickName").getTextContent());
		rider.setType(vratPodelement(xmlRider, "type").getTextContent());
		rider.setDateOfBirth(vratPodelement(xmlRider, "dateOfBirth").getTextContent());
		rider.setNationality(vratPodelement(xmlRider, "nationality").getTextContent());
		rider.setHeightUnit(vratPodelement(xmlRider, "height").getAttribute("unit"));
		rider.setHeight(Double.parseDouble(vratPodelement(xmlRider, "height").getTextContent()));
		Element majorAchievement = vratPodelement(xmlRider, "majorAchievement");
		if (majorAchievement != null) {
			Node children = majorAchievement.getFirstChild();
			while (children != null) {
				if ((children instanceof Element) && ("season".equals(children.getNodeName()))) {
					rider.getAchievements().add(createSeasonAchievement((Element) children));
				}
				children = children.getNextSibling();
			}
		}

		return rider;
	}

	private SeasonAchievement createSeasonAchievement(Element xmlSeasonAchievement) {
		SeasonAchievement seasonAchievement = new SeasonAchievement();
		seasonAchievement.setYear(Integer.parseInt(xmlSeasonAchievement.getAttribute("year")));
		seasonAchievement.setTeam(xmlSeasonAchievement.getAttribute("team"));

		NodeList achievements = xmlSeasonAchievement.getElementsByTagName("achievement");
		for (int i = 0; i < achievements.getLength(); i++) {
			Element xmlAchievement = (Element) achievements.item(i);
			Achievement achievement = new Achievement();
			achievement.setRaceType(xmlAchievement.getAttribute("type"));
			achievement.setAchievement(xmlAchievement.getTextContent());
			seasonAchievement.getAchievements().add(achievement);
		}

		return seasonAchievement;
	}

	private Element vratPodelement(Element xmlElement, String nazovElementu) {
		NodeList xmlDeti = xmlElement.getChildNodes();
		for (int i = 0; i < xmlDeti.getLength(); i++) {
			Node xmlDieta = xmlDeti.item(i);
			if ((xmlDieta instanceof Element) && (nazovElementu.equals(xmlDieta.getNodeName()))) {
				return (Element) xmlDieta;
			}
		}

		return null;
	}

	public UCIRoad citajZXml(File xmlSubor) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder parser;
		try {
			parser = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new RuntimeException("Neviem vytvorit pozadovany parser.", e);
		}

		Document doc;
		try {
			doc = parser.parse(xmlSubor);
		} catch (Exception e) {
			throw new RuntimeException("XML dokument sa nepodarilo precitat alebo rozparsovat.", e);
		}

		return creatUCIRoad(doc.getDocumentElement());
	}

	public static void main(String[] args) {
		DOMReader citac = new DOMReader();
		UCIRoad uciRoad = citac.citajZXml(new File("uciRoad.xml"));

		uciRoad.writeUCIRoad();
	}
        
}
