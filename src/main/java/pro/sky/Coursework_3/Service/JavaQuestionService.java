package pro.sky.Coursework_3.Service;

import org.springframework.stereotype.Service;
import pro.sky.Coursework_3.Domain.Question;
import pro.sky.Coursework_3.Exception.BAD_REQUEST;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    public Set<Question> questions = new HashSet<>();

    @Override
    public void addQuestionAndAnswer(String question, String answer) {
        if (question == null || answer== null ) {
            throw new BAD_REQUEST();}
        addQuestion(new Question(question, answer));
    }

    @Override
    public void addQuestion(Question question) {
        if (question == null) {
            throw new BAD_REQUEST();
        } else {
            questions.add(question);
        }
    }

    @Override
    public void removeQuestion(Question question) {
        if (!questions.contains(question)) {
            throw new BAD_REQUEST();
        }
        else {
            questions.remove(question);
        }
    }
    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomInt = random.nextInt(questions.size());
        List<Question> listQuestions = new ArrayList<>(questions);
        return listQuestions.get(randomInt);
    }
}
