package SatSilverOneOnOne2021.ComparatorAndComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PersonMain{
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(3, "Jack", "Wu"));
        list.add(new Person(2, "Bob", "Smith"));
        list.add(new Person(4, "Luck", "Steve"));
        list.add(new Person(1, "Jack", "Wu"));
        Collections.sort(list, new SortLastFirstID());
        System.out.println(list);
        //1st: if ids are same, then sort by last name
        //  2nd: if last name same, then sort by first name
        //    3rd: if first name same, then sort by id
    }
}
