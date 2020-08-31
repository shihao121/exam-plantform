package exam.ExaminationContext.application;

import exam.ExaminationContext.domain.model.examination.Examination;
import exam.ExaminationContext.domain.model.examination.ExaminationId;
import exam.ExaminationContext.domain.service.PaperClient;
import exam.ExaminationContext.domain.service.PaperDto;
import exam.ExaminationContext.domain.model.examination.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Service
public class ExaminationApplicationService {
    private final ExaminationRepository examinationRepository;
    private PaperClient paperClient;

    @Autowired
    public ExaminationApplicationService(ExaminationRepository examinationRepository) {
        this.examinationRepository = examinationRepository;
    }

    public ExaminationId createExamination(CreateExaminationCommand command) {
        Examination.Paper paper = paperFrom(command);
        ExaminationId examinationId = ExaminationId.nextId();
        Examination examination = Examination.create(examinationId, command.getName(), command.getDesc(),
                command.getTeacherId(), command.getStartTime(), command.getDueTime(), paper);
        examinationRepository.save(examination);
        return examinationId;
    }

    private Examination.Paper paperFrom(CreateExaminationCommand command) {
        PaperDto paperDto = paperClient.getPaperById(command.getPaperId());
        return new Examination.Paper(paperDto.getName(), paperDto.getBlankQuizDtoList().stream()
                .map(blankQuiz -> new Examination.Paper.BlankQuiz(blankQuiz.getName(), blankQuiz.getDesc(),
                        blankQuiz.getReferenceAnswer(), blankQuiz.getScore())).collect(toList()));
    }
}
