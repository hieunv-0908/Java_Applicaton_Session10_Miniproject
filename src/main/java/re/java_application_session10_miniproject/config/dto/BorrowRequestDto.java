package re.java_application_session10_miniproject.config.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class BorrowRequestDto {
    private Long deviceId;

    @NotBlank(message = "Họ và tên không được để trống")
    private String fullName;

    @NotBlank(message = "Mã sinh viên không được để trống")
    @Pattern(regexp = "^[A-Z]{2}\\d{4,8}$", message = "Mã sinh viên không đúng định dạng (VD: SE12345)")
    private String studentCode;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 1, message = "Số lượng tối thiểu là 1")
    private Integer quantity;

    @NotNull(message = "Ngày mượn không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowDate;

    @NotNull(message = "Ngày trả không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    @NotBlank(message = "Vui lòng nhập lý do mượn")
    private String reason;

    // Getters and Setters (Em hãy tự tạo thêm nhé)
}