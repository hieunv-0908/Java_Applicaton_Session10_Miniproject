package re.java_application_session10_miniproject.service.impl;

import re.java_application_session10_miniproject.model.BorrowRequest;
import re.java_application_session10_miniproject.repository.BorrowRequestRepository;
import re.java_application_session10_miniproject.service.BorrowRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowRequestServiceImpl implements BorrowRequestService {

    private final BorrowRequestRepository repository;

    public BorrowRequestServiceImpl(BorrowRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BorrowRequest> getAllRequests() {
        return repository.findAll();
    }

    @Override
    public BorrowRequest getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public BorrowRequest create(BorrowRequest request) {
        request.setId(null);
        request.setStatus("PENDING");
        request.setCreatedAt(LocalDate.now());
        return repository.save(request);
    }

    @Override
    public BorrowRequest update(BorrowRequest request) {
        return repository.save(request);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<BorrowRequest> getByStatus(String status) {
        return repository.findByStatus(status);
    }
}