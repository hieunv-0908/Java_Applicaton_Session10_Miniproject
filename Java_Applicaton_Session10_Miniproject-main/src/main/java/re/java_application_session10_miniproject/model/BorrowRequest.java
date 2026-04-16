package re.java_application_session10_miniproject.model;

import java.time.LocalDate;

public class BorrowRequest {
    private Long id;
    private Long deviceId;

    private String fullName;
    private String studentCode;
    private String email;
    private int quantity;

    private LocalDate borrowDate;
    private LocalDate returnDate;

    private String reason;
    private String status; // PENDING, APPROVED, REJECTED
    private LocalDate createdAt;

    public BorrowRequest() {
    }

    public BorrowRequest(Long id, Long deviceId, String fullName, String studentCode, String email,
                         int quantity, LocalDate borrowDate, LocalDate returnDate,
                         String reason, String status, LocalDate createdAt) {
        this.id = id;
        this.deviceId = deviceId;
        this.fullName = fullName;
        this.studentCode = studentCode;
        this.email = email;
        this.quantity = quantity;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.reason = reason;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}