package SchoolWork.IntroToJava;

public class NHLDriver {
    public static void main(String[] args) {
        NHLTeam team = new NHLTeam("Washington Capitals",
                "Eastern", "Northeast",2000,
                new NHLArena("Verizon", "Verizon Arena", "Washington D.C.", 100000),
                new NHLPlayers("Brian Dai", "Center", "May 16th, 2006", "Great Neck", 22));
        System.out.println(team);
    }
}
