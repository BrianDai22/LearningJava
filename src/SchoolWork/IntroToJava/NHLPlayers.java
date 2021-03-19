package SchoolWork.IntroToJava;

public class NHLPlayers {
    private String name, position, dOfB, cityName;
    private int num;
    public NHLPlayers(String playerName, String positionName, String dateOfBirth, String city, int uNum) {
        name = playerName;
        position = positionName;
        dOfB = dateOfBirth;
        cityName = city;
        num = uNum;
    }
    public String getName() {
        return name;
    }
    public int getNum() {
        return num;
    }

    public String getCityName() {
        return cityName;
    }

    public String getdOfB() {
        return dOfB;
    }

    public String getPosition() {
        return position;
    }

    public String toString() {
        String NHLInfo = "";
        NHLInfo += "Player Name: " + name + "\n";
        NHLInfo += "Position: " + position + "\n";
        NHLInfo += "Date of Birth: " + dOfB + "\n";
        NHLInfo += "City: " + cityName + "\n";
        NHLInfo += "Jersey Number: " + num + "\n";
        return NHLInfo;
    }
}
