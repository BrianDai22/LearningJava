package SchoolWork.IntroToJava;

public class BankTeller {
    private String name;
    private int tellerID;
    private static int count = 0;
    public BankTeller(String name, int tellerID) {
        this.name = name;
        this.tellerID = tellerID;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getTellerID() {
        return tellerID;
    }

    public static int getCount() {
        return count;
    }

    public double getBalance(CustomerAccount account) {
        return account.getBalance();
    }

    public void deposit(CustomerAccount account, double money) {
        account.setBalance(account.getBalance() + money);
    }

    public void withdrawal(CustomerAccount account, double money) {
        account.setBalance(account.getBalance() - money);
    }

    public String toString() {
        String result = "";

        result += "SchoolWork.IntroToJava.Bank Name: " + name + "\n";
        result += "TellerID: " + tellerID + "\n";
        result += "Number of Tellers: " + count;

        return result;
    }
}
