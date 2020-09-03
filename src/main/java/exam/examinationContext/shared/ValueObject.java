package exam.examinationContext.shared;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
