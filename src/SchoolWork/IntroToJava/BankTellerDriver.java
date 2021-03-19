package SchoolWork.IntroToJava;

public class BankTellerDriver {
    public static void main(String[] args) {
        BankTeller teller = new BankTeller("Brian", 2222);
        Branch branch = new Branch("22 League Ave", 911, teller);
        Bank bank = new Bank("Brian's SchoolWork.IntroToJava.Bank", branch);
        CustomerAccount account = new CustomerAccount("Bob", "Something", 100, 99999.99,
                1000);
        //System.out.println(teller);
        System.out.println(bank);
        //System.out.println(branch);
        System.out.println(account);
        System.out.println("Balance: " + teller.getBalance(account));
        teller.deposit(account, 1000);
        System.out.println("New balance: " + teller.getBalance(account));
        teller.withdrawal(account, 100);
        System.out.println("New balance: " + teller.getBalance(account));
    }
}
