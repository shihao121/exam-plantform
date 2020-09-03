package exam.examinationContext.helper;

import exam.examinationContext.domain.service.PaperDto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PaperDtoHelper {
    public static PaperDto.PaperDtoBuilder getPaperDtoBuilder(){
        return PaperDto.builder().blankQuizDtoList(IntStream.range(1, 11)
                .mapToObj(index -> new PaperDto.BlankQuizDto(index + "+1", "第" + index + "题", String.valueOf(index + 1), 20))
                .collect(Collectors.toList()))
                .name("大一期末试卷");
    }
}
