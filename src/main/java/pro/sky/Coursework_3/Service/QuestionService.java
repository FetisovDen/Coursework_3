package pro.sky.Coursework_3.Service;

import pro.sky.Coursework_3.Domain.Question;

import java.util.Collection;

public interface QuestionService {
    void addQuestionAndAnswer(String question, String answer);

    void addQuestion(Question question);

    void removeQuestion(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}
