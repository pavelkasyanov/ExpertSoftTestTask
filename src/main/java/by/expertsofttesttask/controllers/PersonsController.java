package by.expertsofttesttask.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/persons")
public class PersonsController {

    @RequestMapping(method = RequestMethod.GET)
    public String personList()
    {
        return "personList";
    }
}
