package exam.ExaminationContext.domain.model.examination;

import exam.paperContext.shared.Entity;
import exam.paperContext.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(of = {"examinationId"})
public class Examination implements Entity<Examination> {
    private ExaminationId examinationId;
    private Paper paper;
    private String name;
    private String desc;
    private String teacherId;
    private LocalDateTime startTime;
    private LocalDateTime dueTime;

    private Examination(ExaminationId examinationId, String name, String desc, String teacherId, LocalDateTime startTime, LocalDateTime dueTime, Paper paper) {
        this.examinationId = examinationId;
        this.name = name;
        this.desc = desc;
        this.teacherId = teacherId;
        this.startTime = startTime;
        this.dueTime = dueTime;
        this.paper = paper;
    }

    public ExaminationId getExaminationId() {
        return examinationId;
    }

    public Paper getPaper() {
        return paper;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getDueTime() {
        return dueTime;
    }

    public static Examination create(ExaminationId examinationId, String name, String desc, String teacherId, LocalDateTime startTime, LocalDateTime dueTime, Paper paper) {
        validateExamTime(startTime, dueTime);
        return new Examination(examinationId, name, desc, teacherId, startTime, dueTime, paper);
    }

    private static void validateExamTime(LocalDateTime startTime, LocalDateTime dueTime) {
        if (startTime.isBefore(LocalDateTime.now())) {
            throw new IllegalExaminationStartTimeException(startTime);
        }
        if (dueTime.isBefore(startTime)){
            throw new IllegalExaminationDueTimeException(dueTime);
        }
    }

    @Override
    public boolean sameIdentityAs(Examination other) {
        return examinationId.sameValueAs(other.examinationId);
    }

    @Getter
    @AllArgsConstructor
    public static class Paper implements ValueObject<Examination.Paper> {
        private final String paperName;
        private final List<BlankQuiz> blankQuizzes;

        @Override
        public boolean sameValueAs(Examination.Paper other) {
            return false;
        }

        @Getter
        @AllArgsConstructor
        public static class BlankQuiz implements ValueObject<Examination.Paper.BlankQuiz> {
            private final String name;
            private final String desc;
            private final String referenceAnswer;
            private final int score;

            @Override
            public boolean sameValueAs(BlankQuiz other) {
                return false;
            }
        }
    }
}
