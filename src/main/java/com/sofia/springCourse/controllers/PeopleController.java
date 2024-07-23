package com.sofia.springCourse.controllers;

import com.sofia.springCourse.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String index(Model model){
        //get all people from DAO and show with thymeleaf
        model.addAttribute("people", personDAO.index());
        return ("people/index");
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        //get 1 person by her id from DAO and show
        model.addAttribute("person", personDAO.show(id));
        return ("people/show");
    }
}
