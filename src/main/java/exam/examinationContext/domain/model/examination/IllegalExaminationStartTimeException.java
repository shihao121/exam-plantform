package exam.examinationContext.domain.model.examination;

import java.time.LocalDateTime;

public class IllegalExaminationStartTimeException extends IllegalArgumentException {

    public IllegalExaminationStartTimeException(LocalDateTime startTime) {
        super("illegal examination startTime, startTime should before than current time, actual:" + startTime);
    }
}
