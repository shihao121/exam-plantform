package exam.ExaminationContext.domain.model.examination;

import java.time.LocalDateTime;

public class IllegalExaminationDueTimeException extends IllegalArgumentException {
    public IllegalExaminationDueTimeException(LocalDateTime dueTime) {
        super("illegal examination dueTime, duetime should before than current time and after than startTime, actual:" + dueTime);
    }
}
