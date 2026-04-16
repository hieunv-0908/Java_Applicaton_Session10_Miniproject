package re.java_application_session10_miniproject.service;

import re.java_application_session10_miniproject.model.BorrowRequest;
import re.java_application_session10_miniproject.dto.BorrowRequestDto;

import java.util.List;

public interface BorrowRequestService {
    List<BorrowRequest> getAllRequests();
    BorrowRequest getById(Long id);
    BorrowRequest create(BorrowRequest request);
    BorrowRequest createBorrowRequest(BorrowRequestDto dto);
    BorrowRequest update(BorrowRequest request);
    void delete(Long id);
    List<BorrowRequest> getByStatus(String status);
    BorrowRequest approveRequest(Long id);
    BorrowRequest rejectRequest(Long id);
}
