package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.book.*;
import pl.coderslab.student.Student;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/add")
    public String add(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "person/add";
    }

//    @PostMapping("/add")
//    @ResponseBody
//    public String save(@RequestParam String login,
//                       @RequestParam String password,
//                       @RequestParam String email) {
//        personDao.save(Person.builder()
//                .login(login)
//                .password(password)
//                .email(email)
//                .build());
//        return "ok";
//    }

    @PostMapping("/add")
    @ResponseBody
    public String save(Person person) {
        personDao.save(person);
        return "ok";
    }


    @GetMapping("/save")
    @ResponseBody
    public String save() {
        Person person = new Person();
        person.setLogin("arek");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("arek");
        personDetails.setLastName("jozwiak");
        personDetailsDao.save(personDetails);
        person.setPersonDetails(personDetails);
        personDao.save(person);
        return "ok";
    }


}
