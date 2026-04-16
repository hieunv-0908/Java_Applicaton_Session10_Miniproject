package re.java_application_session10_miniproject.dto;

import jakarta.validation.constraints.*;
import re.java_application_session10_miniproject.validator.ValidBorrowDate;
import java.time.LocalDate;

@ValidBorrowDate
public class BorrowRequestDto {
    
    @NotBlank(message = "Không được để trống")
    private String fullName;
    
    @Pattern(regexp = "^[A-Za-z]{2}\\d+$", message = "Mã sinh viên phải bắt đầu bằng 2 chữ cái")
    private String studentCode;
    
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", 
             message = "Email không hợp lệ. Vui lòng nhập đúng định dạng email (ví dụ: user@domain.com)")
    private String email;
    
    @Min(value = 1, message = "Số lượng phải > 0")
    private int quantity;
    
    @Future(message = "Ngày nhận phải ở tương lai")
    private LocalDate borrowDate;
    
    @NotNull(message = "Không được để trống")
    private LocalDate returnDate;
    
    @NotBlank(message = "Không được để trống")
    private String reason;
    
    private Long deviceId;

    // Constructors
    public BorrowRequestDto() {}

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
}
