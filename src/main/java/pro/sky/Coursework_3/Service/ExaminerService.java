package pro.sky.Coursework_3.Service;

import pro.sky.Coursework_3.Domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}