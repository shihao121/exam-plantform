package exam.ExaminationContext.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
