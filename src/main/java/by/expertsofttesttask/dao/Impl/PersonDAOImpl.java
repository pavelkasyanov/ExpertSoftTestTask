package by.expertsofttesttask.dao.Impl;

import by.expertsofttesttask.dao.PersonDAO;
import by.expertsofttesttask.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PersonDAOImpl implements PersonDAO {

    private static List<Person> personList = new ArrayList<Person>();

    @Override
    public void addOrUpdate(Person person) {
        for (ListIterator<Person> personIterator = personList.listIterator();
                personIterator.hasNext();){
            if (personIterator.next().getLogin().equals(person.getLogin())){
                personIterator.set(person);
                return;
            }
        }

        personList.add(person);
    }

    @Override
    public void deleteByLogin(String personLogin) {
        for (ListIterator<Person> personIterator = personList.listIterator();
             personIterator.hasNext();){
            if (personIterator.next().getLogin().equals(personLogin)){
                personIterator.remove();
                return;
            }
        }
    }

    @Override
    public Person getByLogin(String personLogin) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return personList;
    }
}
