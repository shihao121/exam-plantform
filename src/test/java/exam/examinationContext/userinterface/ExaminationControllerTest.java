package exam.examinationContext.userinterface;

import exam.examinationContext.application.CreateExaminationCommand;
import exam.examinationContext.application.ExaminationApplicationService;
import exam.examinationContext.domain.model.examination.ExaminationId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExaminationController.class)
@SpringBootTest
class ExaminationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ExaminationApplicationService examinationApplicationService;

	@Test
	void should_save_examination_add_return_created_status() throws Exception {
		ExaminationId examinationId = ExaminationId.nextId();
		when(examinationApplicationService.createExamination(any(CreateExaminationCommand.class)))
				.thenReturn(examinationId);
		mockMvc.perform(post("/examinations")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(HttpStatus.CREATED.value()));

	}
}