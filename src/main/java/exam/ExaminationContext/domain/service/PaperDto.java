package exam.ExaminationContext.domain.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaperDto {
    private String name;
    private List<BlankQuizDto> blankQuizDtoList;

    @AllArgsConstructor
    @Getter
    @NoArgsConstructor
    public static class BlankQuizDto {
        private String name;
        private String desc;
        private String referenceAnswer;
        private int score;
    }
}
