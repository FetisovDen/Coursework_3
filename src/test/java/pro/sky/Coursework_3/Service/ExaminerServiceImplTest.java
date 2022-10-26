package pro.sky.Coursework_3.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Coursework_3.Domain.Question;
import pro.sky.Coursework_3.Exception.BAD_REQUEST;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

    @BeforeEach
    public void setUp() {
        Mockito.when(questionService.getRandomQuestion())
                .thenReturn(new Question("Wer", "Der"))
                .thenReturn(new Question("dd", "rr"))
                .thenReturn(new Question("drd", "rrr"));
        Mockito.when(questionService.getAll())
                .thenReturn(Set.of(
                        new Question("Wer", "Der"),
                        new Question("dd", "rr"),
                        new Question("drd", "rrr")));
    }

    @Test
    void testGetQuestion() {
        assertThat(examinerServiceImpl.getQuestion(3))
                .containsExactlyInAnyOrderElementsOf(List.of(
                        new Question("Wer", "Der"),
                        new Question("dd", "rr"),
                        new Question("drd", "rrr")));
        assertThatExceptionOfType(BAD_REQUEST.class).isThrownBy(() -> examinerServiceImpl.getQuestion(5));
    }
}