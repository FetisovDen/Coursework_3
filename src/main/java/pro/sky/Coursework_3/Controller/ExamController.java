package pro.sky.Coursework_3.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Coursework_3.Domain.Question;
import pro.sky.Coursework_3.Service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerServiceImpl examinerServiceImpl;

    public ExamController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }
    @GetMapping()
    public Collection<Question> getQuestions(@RequestParam("amount") int amount) {
        return  examinerServiceImpl.getQuestion(amount);
    }
}
