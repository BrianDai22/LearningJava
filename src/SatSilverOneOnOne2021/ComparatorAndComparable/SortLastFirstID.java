package SatSilverOneOnOne2021.ComparatorAndComparable;

import java.util.Comparator;

public class SortLastFirstID implements Comparator<Person> {
    public int compare(Person a, Person b) {
        if(a.lastName.compareTo(b.lastName) != 0) {
            return a.lastName.compareTo(b.lastName);
        } else if(a.firstName.compareTo(b.firstName) != 0){
            return a.firstName.compareTo(b.firstName);
        }
        return a.id.compareTo(b.id);
    }
}
