package by.expertsofttesttask.dao.Impl;

import by.expertsofttesttask.dao.PersonDAO;
import by.expertsofttesttask.models.Person;
import org.springframework.cglib.core.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

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
    public void delete(Person person) {
        personList.remove(person);
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
