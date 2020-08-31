package exam.ExaminationContext.domain.model.examination;

import exam.ExaminationContext.shared.ValueObject;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class ExaminationId implements ValueObject<ExaminationId> {
    private String id;
    @Override
    public boolean sameValueAs(ExaminationId other) {
        return equals(other);
    }

    private ExaminationId(String id){
        this.id = id;
    }

    public static ExaminationId nextId() {
        return new ExaminationId(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ExaminationId examinationId = (ExaminationId) obj;
        return Objects.equals(id, examinationId.id);
    }
}
