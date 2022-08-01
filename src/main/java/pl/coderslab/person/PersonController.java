package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorDao;
import pl.coderslab.person.Person;
import pl.coderslab.person.PersonDao;
import pl.coderslab.person.PersonDetailsDao;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao, AuthorDao authorDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String savePerson() {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Rob");

        personDao.addPerson(Person.builder().
                login("robin").
                build());
        return "Person added successfully";
    }
    @RequestMapping("/connectPersonDetails/{personId}/{personDetailsId}")
    @ResponseBody
    public String connectPersonDetails(@PathVariable Long personId, @PathVariable Long personDetailsId){
        Person person = personDao.findById(personId);
        PersonDetails personDetails = personDetailsDao.findById(personDetailsId);
        person.setPersonDetails(personDetails);
        personDetails.setPerson(person);
        return "joined successfully";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable long id) {
        Person person = personDao.findById(id);
        return person.toString();
    }

    @RequestMapping("/update/{id}/{login}")
    @ResponseBody
    public String updatePerson(@PathVariable long id, @PathVariable String login) {
        Person person = personDao.findById(id);
        person.setLogin(login);
        personDao.updatePerson(person);
        return person.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable long id) {
        Person person = personDao.findById(id);
        personDao.deletePerson(person);
        return "deleted person with id: " + id;
    }
}
