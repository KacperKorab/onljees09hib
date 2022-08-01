package pl.coderslab.publisher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String hello() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher 1");
        publisherDao.savePublisher(publisher);
        return "Id dodanego wydawcy to:"
                + publisher.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String name) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "deleted publisher with id: " + id;
    }


}
