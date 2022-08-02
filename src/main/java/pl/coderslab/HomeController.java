package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.book.BookDao;
import pl.coderslab.dog.Dog;
import pl.coderslab.dog.DogDao;

@Controller
public class HomeController {

    private final DogDao dogDao;
    private final BookDao bookDao;

    public HomeController(DogDao dogDao, BookDao bookDao) {
        this.dogDao = dogDao;
        this.bookDao = bookDao;
    }

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        Dog dog = new Dog();
        dog.setNameDog("Azor");

        dogDao.save(dog);

        return "hello";
    }
}
