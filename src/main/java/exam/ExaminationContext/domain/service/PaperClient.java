package exam.ExaminationContext.domain.service;

import org.springframework.stereotype.Service;

@Service
public interface PaperClient {
    PaperDto getPaperById(String paperId);
}
