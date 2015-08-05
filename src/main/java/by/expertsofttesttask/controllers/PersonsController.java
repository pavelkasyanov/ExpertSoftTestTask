package by.expertsofttesttask.controllers;

import by.expertsofttesttask.exeptions.ParsePersonExeption;
import by.expertsofttesttask.models.Person;
import by.expertsofttesttask.models.comporators.*;
import by.expertsofttesttask.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonsController {

    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String personList(@RequestParam(value = "sortby",required = false) String sortBy)
    {
        if (sortBy != null) {
            return "redirect:persons/page/1/?sortby=" + sortBy;
        }
        return "redirect:persons/page/1";
    }

    @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.GET)
    public String personListFromPage(ModelMap model,
                                     @PathVariable("pageNumber") int pageNumber,
                                     @RequestParam(value = "sortby",required = false) String sortBy)
    {
        PersonComparator personComparator = null;
        if (sortBy != null) {
            personComparator = personService.getPersonCompator(sortBy);
        }

        List<Person> personList = personService.getFromPage(pageNumber, personComparator);
        model.addAttribute("personList", personList);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("isNextPage", personService.isNextPage(pageNumber));
        model.addAttribute("sortBy", sortBy);

        return "personList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPersonView() {
        return "addPerson";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPersonFromFile(ModelMap model,
                                    @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                personService.addPersonFromFile(file.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParsePersonExeption ex) {
                model.addAttribute("error", ex.getMessage());
            }
        }

        return "addPerson";
    }
}
