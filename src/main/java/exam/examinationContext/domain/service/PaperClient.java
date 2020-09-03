package exam.examinationContext.domain.service;

import org.springframework.stereotype.Service;

public interface PaperClient {
    PaperDto getPaperById(String paperId);
}
