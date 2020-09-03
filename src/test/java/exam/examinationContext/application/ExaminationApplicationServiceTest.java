package exam.examinationContext.application;

import exam.examinationContext.domain.model.examination.Examination;
import exam.examinationContext.domain.model.examination.ExaminationId;
import exam.examinationContext.domain.model.examination.ExaminationRepository;
import exam.examinationContext.domain.service.PaperClient;
import exam.examinationContext.helper.CreateExaminationCommandHelper;
import exam.examinationContext.helper.PaperDtoHelper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ExaminationApplicationServiceTest {

	private final PaperClient paperClient = mock(PaperClient.class);

	private final ExaminationRepository examinationRepository = mock(ExaminationRepository.class);

	private final ExaminationApplicationService examinationApplicationService;

	public ExaminationApplicationServiceTest(){
		examinationApplicationService = new ExaminationApplicationService(examinationRepository, paperClient);
	}

	@Test
	void should_create_examination() {
		CreateExaminationCommand command = CreateExaminationCommandHelper.getCreateExaminationCommandBuilder().build();
		when(paperClient.getPaperById(command.getPaperId())).thenReturn(PaperDtoHelper.getPaperDtoBuilder().build());

		ExaminationId examinationId = examinationApplicationService.createExamination(command);
		ArgumentCaptor<Examination> argumentCaptor = ArgumentCaptor.forClass(Examination.class);
		verify(examinationRepository).save(argumentCaptor.capture());
		Examination examination = argumentCaptor.getValue();

		assertEquals(examination.getExaminationId(), examinationId);
		assertEquals(10, examination.getPaper().getBlankQuizzes().size());
		assertEquals("大一期末考试", examination.getName());
		assertEquals("期末考试", examination.getDesc());
	}
}