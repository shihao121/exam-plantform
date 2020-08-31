package exam.ExaminationContext.userinterface;

import exam.ExaminationContext.application.CreateExaminationCommand;
import exam.ExaminationContext.application.ExaminationApplicationService;
import exam.ExaminationContext.domain.model.examination.ExaminationId;
import exam.paperContext.userInterface.PaperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExaminationController {

    private final ExaminationApplicationService examinationApplicationService;

    @Autowired
    public ExaminationController(ExaminationApplicationService examinationApplicationService) {
        this.examinationApplicationService = examinationApplicationService;
    }

    @PostMapping("/examinations")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    ExaminationDto assemble(@RequestBody CreateExaminationCommand command) {
        final ExaminationId examinationId = examinationApplicationService.createExamination(command);
        return ExaminationDto.from(examinationId);
    }
}
