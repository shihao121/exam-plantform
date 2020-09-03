package exam.examinationContext.domain.service;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
//mock impl. Subsequent use spring cloud openfeign
public class PaperClientImpl implements PaperClient {
    @Override
    public PaperDto getPaperById(String paperId) {
        return new PaperDto("大一期末试卷", IntStream.range(1, 11)
                .mapToObj(index -> new PaperDto.BlankQuizDto(index + "+1", "第" + index + "题", String.valueOf(index + 1), 20))
                .collect(Collectors.toList()));
    }
}
