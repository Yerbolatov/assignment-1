package models;

import java.util.ArrayList;
import java.util.Comparator;

public class School {
    private String name;
    public ArrayList<Person> persons;

    public School() {
        persons = new ArrayList<>();
    }

    public School(String name) {
        setName(name);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addMember(Person person) {
        persons.add(person);
    }
    public void sortMembers() {
        persons.sort(Comparator.comparing(Person::getSurname));
    }

    @Override
    public String toString() {
        for (Person person : persons) {
            System.out.println(person);
        }
        return persons.toString();
    }
}
