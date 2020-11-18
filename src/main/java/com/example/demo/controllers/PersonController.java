package com.example.demo.controllers;

import com.example.demo.commands.PersonCommand;
import com.example.demo.domain.Person;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.services.PersonService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Controller
public class PersonController implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {

    private final PersonRepository personRepository;
    private final PersonService personService;

    public PersonController(PersonRepository personRepository, PersonService personService) {
        System.out.println("PersonController constructor is invoked");
        this.personRepository = personRepository;
        this.personService = personService;
    }
    

    @RequestMapping({"", "/", "/people"})
    public String getPeople(Model model){
        model.addAttribute("people",personRepository.findAll());
        return "list";
    }

    @RequestMapping("people/new")
    public String newPerson(Model model){
        model.addAttribute("person", new PersonCommand());
        return "personForm";
    }

    @PostMapping("/people/new")
    public String saveOrUpdate(@ModelAttribute PersonCommand command){
        PersonCommand savedCommand = personService.savePersonCommand(command);
        return "redirect:/people/";
    }

    //Lifecycle
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After PersonController properties set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy method of person bean is invoked!");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean Factory of PersonController has been set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context has been set");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("The Post Construct method of PersonController has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("The preDestroy method of PersonController has been called");
    }

    public void beforeInit(){
        System.out.println("Before Init - Called by Bean Post Processor");
    }

    public void afterInit(){
        System.out.println("After init called by Bean Post Processor");
    }
}
