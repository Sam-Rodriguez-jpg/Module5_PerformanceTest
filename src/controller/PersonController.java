package controller;

import model.PersonModel;
import service.PersonService;

import java.util.List;

public class PersonController {
    private final PersonService registerService = new PersonService();

    // Create
    public void registerPerson(String namePerson, String email, String password, String role) {
        PersonModel personModel = new PersonModel(namePerson, email, password, role);
        registerService.registerPerson(personModel);
    }

    // Find All
    private final PersonService personService = new PersonService();

    public List<PersonModel> listAllPeople() {
        return personService.getAllPeople();
    }

}
