package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    @GetMapping("/save")
    @ResponseBody
    public String save() {
        authorDao.save(Author.builder().
                firstName("Bruce")
                .lastName("AAAAA")
                .build());
        return "ok";
    }

    @GetMapping("/edit")
    @ResponseBody
    public String edit() {
        Author byId = authorDao.findById(1l);
        byId.setLastName("Eckel");
        authorDao.update(byId);
        return "ok";
    }

    @GetMapping("/get")
    @ResponseBody
    public String get() {
        Author byId = authorDao.findById(1l);
        System.out.println(byId);
        return "ok";
    }

    @GetMapping("/delete")
    @ResponseBody
    public String delete() {
        Author byId = authorDao.findById(1l);
        authorDao.delete(byId);
        return "ok";
    }
}
