package service;

import dao.PartnerDao;
import dao.PersonDao;
import dao.UserDao;
import model.PersonModel;

import java.util.List;

public class PersonService {
    private final PersonDao personDao = new PersonDao();
    private final UserDao userDao = new UserDao();
    private final PartnerDao partnerDao = new PartnerDao();

    // Create
    public void registerPerson(PersonModel personModel) {
        // Save in persons table
        personDao.create(personModel);

        // Depending on role, also register in corresponding table
        if (personModel.getRole().equalsIgnoreCase("User")) {
            userDao.create(personModel.getIdPerson());
            System.out.println("User registered successfully");
        } else if (personModel.getRole().equalsIgnoreCase("Partner")) {
            partnerDao.create(personModel.getIdPerson());
            System.out.println("Partner registered successfully");
        } else {
            System.out.println("Unknow role: " + personModel.getRole());
        }
    }

    // Find All
    public List<PersonModel> getAllPeople() {
        return personDao.findAll();
    }

}
