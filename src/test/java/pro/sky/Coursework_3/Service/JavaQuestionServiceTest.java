package pro.sky.Coursework_3.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Coursework_3.Domain.Question;
import pro.sky.Coursework_3.Exception.BAD_REQUEST;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @ParameterizedTest
    @CsvSource({"dru,tru", "abu,dbu", "drq,qer"})
    void testAddQuestions(String question, String answer) {
        javaQuestionService.addQuestionAndAnswer(question, answer);
        assertEquals(javaQuestionService.questions, Set.of(new Question(question, answer)));
        assertThatExceptionOfType(BAD_REQUEST.class).isThrownBy(() -> javaQuestionService.addQuestionAndAnswer("", null));
    }

    @Test
    void testAddQuestion() {
        Question question1 = new Question("s","d");
        javaQuestionService.addQuestion(question1);
        assertEquals(javaQuestionService.questions, Set.of(question1));
        assertThatExceptionOfType(BAD_REQUEST.class).isThrownBy(() -> javaQuestionService.addQuestion(null));
    }

    @ParameterizedTest
    @CsvSource({"dru,tru", "abu,dbu", "drq,qer"})
    void testRemoveQuestion(String question, String answer) {
        assertThatExceptionOfType(BAD_REQUEST.class).isThrownBy(() -> javaQuestionService.removeQuestion(new Question(question,answer)));
        javaQuestionService.addQuestionAndAnswer(question, answer);
        javaQuestionService.removeQuestion(new Question(question,answer));
        assertEquals(javaQuestionService.questions, Set.of());
    }

    @ParameterizedTest
    @CsvSource({"dru,tru", "abu,dbu", "drq,qer"})
    void testGetAll(String question, String answer) {
        javaQuestionService.addQuestionAndAnswer(question, answer);
        javaQuestionService.addQuestionAndAnswer("d","p");
        assertEquals(javaQuestionService.getAll(), Set.of(new Question(question,answer),new Question("d","p")));
    }

    @ParameterizedTest
    @CsvSource({"dru,tru", "abu,dbu", "drq,qer"})
    void testGetRandomQuestion(String question, String answer) {
        javaQuestionService.addQuestionAndAnswer(question, answer);
        assertEquals(javaQuestionService.getRandomQuestion(), new Question(question,answer));
    }
}