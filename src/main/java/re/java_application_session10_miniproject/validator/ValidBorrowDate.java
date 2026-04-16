package re.java_application_session10_miniproject.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BorrowDateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBorrowDate {
    String message() default "Ngày trả phải sau ngày nhận";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
