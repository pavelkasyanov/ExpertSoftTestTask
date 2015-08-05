package by.expertsofttesttask.models.comporators;

import by.expertsofttesttask.models.Person;

import java.util.Comparator;

public class PersonEmailComparator extends PersonComparator {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getEmail().compareToIgnoreCase(o2.getEmail());
    }
}
