package exam.examinationContext.infrastructure;

import exam.examinationContext.domain.model.examination.Examination;
import exam.examinationContext.domain.model.examination.ExaminationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class MemoryExaminationRepository implements ExaminationRepository {
    private final Set<Examination> examinations = new HashSet<>();

    @Override
    public void save(Examination examination) {
        examinations.add(examination);
    }
}
