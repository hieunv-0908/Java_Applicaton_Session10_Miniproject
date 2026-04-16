package re.java_application_session10_miniproject.service;

import re.java_application_session10_miniproject.model.BorrowRequest;

import java.util.List;

public interface BorrowRequestService {
    List<BorrowRequest> getAllRequests();
    BorrowRequest getById(Long id);
    BorrowRequest create(BorrowRequest request);
    BorrowRequest update(BorrowRequest request);
    void delete(Long id);
    List<BorrowRequest> getByStatus(String status);
}