package pl.coderslab.book;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    @ResponseBody
    public void test() {
        Book book = new Book();
        book.setTitle("22");

        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
        constraintViolations.forEach(
                cv -> System.out.println(cv.getPropertyPath() + " : " + cv.getMessage())
        );
    }
}
