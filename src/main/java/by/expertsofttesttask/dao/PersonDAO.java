package by.expertsofttesttask.dao;

import by.expertsofttesttask.models.Person;

import java.util.List;

public interface PersonDAO {
    void addOrUpdate(Person person);
    void delete(Person person);
    Person getByLogin(String personLogin);
    List<Person> getAll();
}
