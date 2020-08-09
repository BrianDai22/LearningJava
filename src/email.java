import java.util.*;

public class email {
    /*
    **** Do it with Union-Find ****
Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
Example 1:
Input:
accounts = [
    ["John", "johnsmith@mail.com", "john00@mail.com"],
    ["John", "johnnybravo@mail.com"],
    ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
    ["Mary", "mary@mail.com"]]
Output: [
    ["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
    ["John", "johnnybravo@mail.com"],
    ["Mary", "mary@mail.com"]]
Explanation:
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
     */
    /*
    public List<List<String>> accountsMerge(List<List<String>> emails) {
        Map<String, String> emailToOwner = new HashMap<>(); // <email, person>
        Map<String, String> emailParents = new HashMap<>(); // <child, parent>
        Map<String, HashSet<String>> unions = new HashMap<>(); // <rootEmail, set of child email>

        for (List<String> a : emails) {
            for (int i = 1; i < a.size(); i++) {
                emailParents.put(a.get(i), a.get(i));
                emailToOwner.put(a.get(i), a.get(0));
            }
        }

        for (List<String> account : emails) {
            String parent = find(account.get(1), emailParents);
            for (int i = 2; i < account.size(); i++) {
                emailParents.put(find(account.get(i), emailParents), parent);​
            }
        }

        return null;

    }

    public String find(String account, Map<String, String> parents) {
        if (account.equals(parents.get(account)))
            return account;
        return find(parents.get(account), parents);
    }

     */
}
