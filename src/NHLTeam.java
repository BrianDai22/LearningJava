public class NHLTeam {
    private String name, conference, divison;
    private int years;
    private NHLPlayers players;
    private NHLArena arena;

    public NHLTeam(String teamName, String conferenceName, String divisonName, int yearSinceCreation,
                   NHLArena arenaCharacteristics, NHLPlayers player) {
        name = teamName;
        conference = conferenceName;
        divison = divisonName;
        years = yearSinceCreation;
        players = player;
        arena = arenaCharacteristics;
    }

    public String getName() {
        return name;
    }

    public String getConference() {
        return conference;
    }

    public String getDivison() {
        return divison;
    }

    public int getYears() {
        return years;
    }

    public NHLPlayers getPlayers() {
        return players;
    }

    public NHLArena getArena() {
        return arena;
    }
    public String toString() {
        String NHLInfo = "";
        NHLInfo += "Team Name: " + name + "\n";
        NHLInfo += "Conference: " + conference + "\n";
        NHLInfo += "Divison: " + divison + "\n";
        NHLInfo += "Years: " + years + "\n";
        NHLInfo += "Players: " + players + "\n";
        NHLInfo += "Arena: " + arena + "\n";

        return NHLInfo;
    }
}