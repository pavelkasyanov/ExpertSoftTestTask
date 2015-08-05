package by.expertsofttesttask.services.Impl;

import by.expertsofttesttask.dao.PersonDAO;
import by.expertsofttesttask.exeptions.ParsePersonExeption;
import by.expertsofttesttask.models.Person;
import by.expertsofttesttask.models.comporators.PersonComparator;
import by.expertsofttesttask.models.comporators.PersonNameComparator;
import by.expertsofttesttask.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDAO personDAO;

    private static final int itemCountForPage = 10;

    private final ReentrantLock addLock = new ReentrantLock();
    private final ReentrantLock sortLock = new ReentrantLock();

    private static final Map<String, PersonComparator> personComparators;
    static {
        Map<String, PersonComparator> aMap = new ConcurrentHashMap<>();
        aMap.put("name", new PersonNameComparator());
        aMap.put("surname", new PersonNameComparator());
        aMap.put("login", new PersonNameComparator());
        aMap.put("email", new PersonNameComparator());
        aMap.put("phone", new PersonNameComparator());
        personComparators = Collections.unmodifiableMap(aMap);
    }

    @Override
    public List<Person> getAll() {
        return personDAO.getAll();
    }

    @Override
    public synchronized List<Person> getFromPage(int pageNumber, PersonComparator personComparator) {
        int begin = (pageNumber - 1) * itemCountForPage;
        if (begin > personDAO.getAll().size() || begin < 0) {
            return null;
        }

        int end = begin + itemCountForPage;
        if (end > personDAO.getAll().size()) {
            end = personDAO.getAll().size();
        }

        sortLock.lock();
        try {
            List<Person> allPerson = personDAO.getAll();
            if (personComparator != null) {
                List<Person> temp = new ArrayList(allPerson);
                Collections.sort(temp, personComparator);
                allPerson = temp;
            }

            return allPerson.subList(begin, end);
        } finally {
            sortLock.unlock();
        }

        //return null;
    }

    @Override
    public synchronized void addPersonFromFile(InputStream inputStream) {
        addLock.lock();
        try {
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line = null;
                String cvsSplitBy = ",";
                long i = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] person = line.split(cvsSplitBy);

                    i++;
                    if (person.length != 5) {
                        throw new ParsePersonExeption(String.format("error arguments count in line %d '%s'",
                                                        i, line));
                    }

                    personDAO.addOrUpdate(new Person(person[0], person[1],
                            person[2], person[3], person[4]));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }finally {
            addLock.unlock();
        }
    }

    @Override
    public int itemCountForPage() {
        return itemCountForPage;
    }

    @Override
    public synchronized boolean isNextPage(int currentPageNumber) {
        int pageCount = personDAO.getAll().size() / itemCountForPage;
        if (currentPageNumber < pageCount + 1 && currentPageNumber > 0){
            return true;
        }

        return false;
    }

    @Override
    public PersonComparator getPersonCompator(String compatorName) {
        return personComparators.get(compatorName);
    }
}
