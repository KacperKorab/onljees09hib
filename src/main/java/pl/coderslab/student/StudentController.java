package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        String[] a = new String[] {"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }

    @GetMapping("/add")
    public String add(Model model){
        Student student = new Student();
        student.setFirstName("arek");
        model.addAttribute("student", student);
        return "student/add";
    }

    @PostMapping("/add")
    public String save(Student student, Model model){
        model.addAttribute("student", student);
        return "student/success";
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("java", "SQL", "REST", "git");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("java","programming");
    }
}
