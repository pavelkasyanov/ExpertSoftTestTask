package by.expertsofttesttask.models.comporators;


import by.expertsofttesttask.models.Person;

public class PersonSurnameCompator extends PersonComparator {
    @Override
    public int compare(Person a, Person b) {
        return a.getSurname().compareToIgnoreCase(b.getSurname());
    }
}
