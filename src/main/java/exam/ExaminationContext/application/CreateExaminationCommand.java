package exam.ExaminationContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateExaminationCommand {
    private String name;
    private String desc;
    private LocalDateTime startTime;
    private LocalDateTime dueTime;
    private String teacherId;
    private String PaperId;
}
