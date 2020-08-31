package exam.ExaminationContext.domain.model.examination;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExaminationTest {

    final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";

    List<Examination.Paper.BlankQuiz> blankQuizzes = Arrays.asList(
            new Examination.Paper.BlankQuiz("1 + 1 = ?", "first question", "2", 20),
            new Examination.Paper.BlankQuiz("1 + 2 = ?", "second question", "3", 20),
            new Examination.Paper.BlankQuiz("1 + 3 = ?", "third question", "4", 20),
            new Examination.Paper.BlankQuiz("1 + 4 = ?", "fourth question", "5", 20),
            new Examination.Paper.BlankQuiz("1 + 5 = ?", "fifth question", "6", 20)
    );


    @Test
    public void should_throw_exception_when_examination_start_time_illegal() {
        assertThrows(IllegalExaminationStartTimeException.class, () -> Examination.create(ExaminationId.nextId(), "奥数期末考试", "暑期培训奥数期末考试", teacherId,
                LocalDateTime.now().plusSeconds(-1), LocalDateTime.now().plusSeconds(-1), new Examination.Paper("final exam paper", blankQuizzes)));
    }
}