package SchoolWork.IntroToJava;

public class CustomerAccount {
    private String name, accountType;
    private int ID, accountNumber;
    private double balance;
    public CustomerAccount(String name, String accountType, int ID, double balance, int accountNumber) {
        this.name = name;
        this.accountType = accountType;
        this.ID = ID;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getID() {
        return ID;
    }

    public String getAccountType() {
        return accountType;
    }

    public String toString() {
        String result = "";
        result += "Name: " + name + "\n";
        result += "Account Type: " + accountType + "\n";
        result += "ID: " + ID + "\n";
        result += "Balance:  " + balance + "\n";
        result += "AccountNumber: " + accountNumber + "\n";
        return result;
    }
}
