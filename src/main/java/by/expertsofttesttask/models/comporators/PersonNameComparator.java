package by.expertsofttesttask.models.comporators;

import by.expertsofttesttask.models.Person;

import java.util.Comparator;

public class PersonNameComparator extends PersonComparator {
    @Override
    public int compare(Person a, Person b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
