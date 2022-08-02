package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }


    @GetMapping("/save")
    @ResponseBody
    public String save() {

        Author byId1 = authorDao.findById(1l);
        Author byId2 = authorDao.findById(2l);
        List<Author> objects = new ArrayList<>();
        objects.add(byId1);
        objects.add(byId2);

        bookDao.save(Book.builder().
                title("Thinking in PHP")
                .description("Book fo java")
                .publisher(publisherDao.findById(1l))
                .authors(objects)
                .rating(4)
                .build());
        return "ok";
    }

    @GetMapping("/edit")
    @ResponseBody
    public String edit() {
        Book byId = bookDao.findById(1l);
        byId.setTitle("Thinking in Java");
        bookDao.update(byId);
        return "ok";
    }

    @GetMapping("/get")
    @ResponseBody
    public String get() {
        Book byId = bookDao.findById(1l);
        System.out.println(byId);
        return "ok";
    }

    @GetMapping("/delete")
    @ResponseBody
    public String delete() {
        Book byId = bookDao.findById(1l);
        bookDao.delete(byId);
        return "ok";
    }
}
