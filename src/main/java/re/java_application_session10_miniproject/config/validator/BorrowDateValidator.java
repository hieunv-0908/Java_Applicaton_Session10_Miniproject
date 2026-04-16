package re.java_application_session10_miniproject.config.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.itlab.dto.BorrowRequestDto;

import java.time.LocalDate;

public class BorrowDateValidator implements ConstraintValidator<ValidBorrowDate, BorrowRequestDto> {

    @Override
    public boolean isValid(BorrowRequestDto dto, ConstraintValidatorContext context) {
        // Nếu một trong hai ngày để trống, để @NotNull xử lý
        if (dto.getBorrowDate() == null || dto.getReturnDate() == null) {
            return true;
        }

        // Logic chính: Ngày trả phải sau ngày mượn
        boolean isValid = dto.getReturnDate().isAfter(dto.getBorrowDate());

        if (!isValid) {
            // Gắn lỗi vào đúng trường returnDate để hiển thị ở UI cho chuẩn
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("returnDate")
                    .addConstraintViolation();
        }

        return isValid;
    }
}