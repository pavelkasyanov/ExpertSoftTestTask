package by.expertsofttesttask.services;

import by.expertsofttesttask.models.Person;
import by.expertsofttesttask.models.comporators.PersonComparator;

import java.io.InputStream;
import java.util.List;

public interface PersonService {

    List<Person> getAll();
    List<Person> getFromPage(int pageNumber, PersonComparator personComparator);

    void addPersonFromFile(InputStream inputStream);

    int itemCountForPage();

    boolean isNextPage(int currentPageNumber);

    PersonComparator getPersonCompator(String compatorName);
}
