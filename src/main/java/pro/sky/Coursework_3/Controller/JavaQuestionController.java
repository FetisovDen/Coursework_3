package pro.sky.Coursework_3.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Coursework_3.Domain.Question;
import pro.sky.Coursework_3.Service.QuestionService;

import java.util.Collection;


@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public void add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        questionService.addQuestionAndAnswer(question, answer);
    }

    @GetMapping(path = "/remove")
    public void remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        questionService.removeQuestion(new Question(question, answer));
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

}
