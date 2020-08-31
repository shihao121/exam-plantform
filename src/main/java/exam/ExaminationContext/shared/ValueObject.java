package exam.ExaminationContext.shared;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
