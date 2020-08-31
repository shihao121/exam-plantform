package exam.ExaminationContext.userinterface;

import exam.ExaminationContext.domain.model.examination.ExaminationId;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ExaminationDto {
    private String uri;

    public static ExaminationDto from(ExaminationId examinationId) {
        return new ExaminationDto("examinations/" + examinationId.getId());
    }
}
