package SchoolWork.IntroToJava;

public class Bank {
    private String name;
    private Branch branch;
    public Bank(String name, Branch branch) {
        this.name = name;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public Branch getBranch() {
        return branch;
    }

    public String toString() {
        String result = "";
        result += "SchoolWork.IntroToJava.Bank Name: " + name + "\n";
        result += "SchoolWork.IntroToJava.Branch Info: " + branch + "\n";
        return result;
    }
}
