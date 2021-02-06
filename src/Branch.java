public class Branch {
    private String address;
    private int number;
    private BankTeller bankTeller;
    private static int count = 0;
    public Branch(String address, int number, BankTeller bankTeller) {
        this.address = address;
        this.number = number;
        this.bankTeller = bankTeller;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String getAddress() {
        return address;
    }

    public int getNumber() {
        return number;
    }

    public BankTeller getBankTeller() {
        return bankTeller;
    }


    public String toString() {
        String result = "";
        result += "Bank Address: " + address + "\n";
        result += "Bank Phone Number: " + number + "\n";
        result += "Bank Teller Info: " + "\n" + bankTeller + "\n";
        result += "Number of Branches Created: " + count;
        return result;
    }
}
