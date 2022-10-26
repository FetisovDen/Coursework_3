package pro.sky.Coursework_3.Service;

import org.springframework.stereotype.Service;
import pro.sky.Coursework_3.Domain.Question;
import pro.sky.Coursework_3.Exception.BAD_REQUEST;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random;
    private QuestionService questionService;

    public ExaminerServiceImpl( QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount < 1||amount > questionService.getAll().size()){
            throw new BAD_REQUEST();
        }
        Set<Question> randomQuestionList = new HashSet<>();
        for(int i = 0; i <= amount-1;i++){
            Question random = questionService.getRandomQuestion();
            if (randomQuestionList.contains(random)){i--;}
            randomQuestionList.add(random);}
        return randomQuestionList;
    }
}
