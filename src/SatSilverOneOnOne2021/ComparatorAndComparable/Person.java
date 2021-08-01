package SatSilverOneOnOne2021.ComparatorAndComparable;

public class Person{ // implements Comparable<Person>{
    Integer id;
    String firstName;
    String lastName;

    public Person(Integer id, String firstName, String lastName){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

/* @Override
    public int compareTo(Person o) {
        // ascending
        // neg value, 0, pos value
        return this.firstName.compareTo(o.firstName);
        // if this.id < o.id
        // if this.id == o.id
        // if this.id > o.id

        // for descending
        // return o.id - this.id;
    }*/
