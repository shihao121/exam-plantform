package exam.ExaminationContext.domain.model.examination;

import exam.ExaminationContext.shared.ValueObject;

import java.util.Objects;

public class ExaminationId implements ValueObject<ExaminationId> {
    private String id;
    @Override
    public boolean sameValueAs(ExaminationId other) {
        return equals(other);
    }

    public static ExaminationId nextId() {
        //TODO Generate ID
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ExaminationId examinationId = (ExaminationId) obj;
        return Objects.equals(id, examinationId.id);
    }
}
