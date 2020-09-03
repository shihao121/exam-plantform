package exam.examinationContext.helper;

import exam.examinationContext.application.CreateExaminationCommand;

import java.time.LocalDateTime;

public class CreateExaminationCommandHelper {
	public static CreateExaminationCommand.CreateExaminationCommandBuilder getCreateExaminationCommandBuilder(){
		return CreateExaminationCommand.builder().name("大一期末考试").desc("期末考试").startTime(LocalDateTime.now().plusHours(1))
				.dueTime(LocalDateTime.now().plusHours(2))
				.paperId("paper-6b35fdd8-31de-4af4-9420-3331058260c5")
				.teacherId("teacher-6b35fdd8-31de-4af4-9420-3331058260c5");
	}
}
