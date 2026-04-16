package re.java_application_session10_miniproject.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import re.java_application_session10_miniproject.dto.BorrowRequestDto;
import java.time.LocalDate;

public class BorrowDateValidator implements ConstraintValidator<ValidBorrowDate, BorrowRequestDto> {

    @Override
    public void initialize(ValidBorrowDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(BorrowRequestDto dto, ConstraintValidatorContext context) {
        if (dto.getBorrowDate() == null || dto.getReturnDate() == null) {
            return true; // Let other annotations handle null validation
        }
        
        if (dto.getReturnDate().isBefore(dto.getBorrowDate()) || 
            dto.getReturnDate().isEqual(dto.getBorrowDate())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                "Ngày trả phải sau ngày nhận"
            )
            .addPropertyNode("returnDate")
            .addConstraintViolation();
            return false;
        }
        
        return true;
    }
}
