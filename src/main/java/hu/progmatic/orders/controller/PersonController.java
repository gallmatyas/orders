package hu.progmatic.orders.controller;

import hu.progmatic.orders.model.Person;
import hu.progmatic.orders.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public String listPersons(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        return "list";
    }

    @GetMapping("/{id}")
    public String viewPerson(@PathVariable Long id, Model model) {
        personService.getPersonById(id).ifPresent(person -> model.addAttribute("person", person));
        return "view";
    }

    @GetMapping("/add")
    public String addPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "add";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person person) {
        personService.addPerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/{id}/edit")
    public String editPersonForm(@PathVariable Long id, Model model) {
        personService.getPersonById(id).ifPresent(person -> model.addAttribute("person", person));
        return "edit";
    }


    @PostMapping("/{id}/edit")
    public String editPerson(@ModelAttribute Person person) {
        personService.updatePerson(person);
        return "redirect:/persons";
    }


    @GetMapping("/{id}/delete")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }

}
