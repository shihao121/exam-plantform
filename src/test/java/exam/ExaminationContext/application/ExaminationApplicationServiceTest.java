package exam.ExaminationContext.application;

import exam.ExaminationContext.domain.model.examination.Examination;
import exam.ExaminationContext.domain.model.examination.ExaminationId;
import exam.ExaminationContext.domain.model.examination.ExaminationRepository;
import exam.ExaminationContext.domain.service.PaperClient;
import exam.ExaminationContext.domain.service.PaperDto;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ExaminationApplicationServiceTest {

	private PaperClient paperClient = mock(PaperClient.class);

	private ExaminationRepository examinationRepository = mock(ExaminationRepository.class);

	private final ExaminationApplicationService examinationApplicationService;
	final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
	final String paperId = "paper-6b35fdd8-31de-4af4-9420-3331058260c5";

	public ExaminationApplicationServiceTest(){
		examinationApplicationService = new ExaminationApplicationService(examinationRepository, paperClient);
	}

	@Test
	void should_create_examination() {
		CreateExaminationCommand command = new CreateExaminationCommand("大一期末考试", "期末考试",
				LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2), teacherId, paperId);
		when(paperClient.getPaperById(command.getPaperId())).thenReturn(new PaperDto("大一期末试卷", IntStream.range(1, 11)
				.mapToObj(index -> new PaperDto.BlankQuizDto(index + "+1", "第" + index + "题", String.valueOf(index + 1), 20))
				.collect(Collectors.toList())));
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