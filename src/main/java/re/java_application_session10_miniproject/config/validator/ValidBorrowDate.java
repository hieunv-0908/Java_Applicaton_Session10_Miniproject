package re.java_application_session10_miniproject.config.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE}) // Áp dụng cho cấp Class
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BorrowDateValidator.class) // Chỉ định file logic xử lý
@Documented
public @interface ValidBorrowDate {
    String message() default "Ngày trả phải sau ngày mượn ít nhất 1 ngày";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}