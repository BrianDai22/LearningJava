package SchoolWork.IntroToJava;

public class NHLArena {
    private String sponsor, name, location;
    private int maxCapacity;
    public NHLArena(String sponsorName, String arenaName, String locationOfArena, int maxCapacityOfArena) {
        sponsor = sponsorName;
        name = arenaName;
        location = locationOfArena;
        maxCapacity = maxCapacityOfArena;
    }
    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getLocation() {
        return location;
    }

    public String getSponsor() {
        return sponsor;
    }
    public String toString() {
        String NHLInfo = "";
        NHLInfo += "Arena Name: " + name + "\n";
        NHLInfo += "Sponsor: " + sponsor + "\n";
        NHLInfo += "Location: " + location + "\n";
        NHLInfo += "Max Capacity: " + maxCapacity + "\n";
        return NHLInfo;
    }
}
