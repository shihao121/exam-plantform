package exam.examinationContext.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class CreateExaminationCommand {
    private String name;
    private String desc;
    private LocalDateTime startTime;
    private LocalDateTime dueTime;
    private String teacherId;
    private String paperId;
}
