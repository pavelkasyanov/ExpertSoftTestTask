package by.expertsofttesttask.models.comporators;

import by.expertsofttesttask.models.Person;

import java.util.Comparator;

public class PersonLoginComparator extends PersonComparator {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLogin().compareToIgnoreCase(o2.getLogin());
    }
}
