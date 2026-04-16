package re.java_application_session10_miniproject.repository;

import re.java_application_session10_miniproject.model.BorrowRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BorrowRequestRepository {

    private final List<BorrowRequest> data = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public BorrowRequestRepository() {
        data.add(new BorrowRequest(
                idGenerator.getAndIncrement(),
                1L,
                "Nguyen Van A",
                "SV001",
                "a@gmail.com",
                2,
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(3),
                "Mượn để làm bài tập",
                "PENDING",
                LocalDate.now()
        ));
    }

    public List<BorrowRequest> findAll() {
        return new ArrayList<>(data);
    }

    public Optional<BorrowRequest> findById(Long id) {
        return data.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    public BorrowRequest save(BorrowRequest request) {
        if (request.getId() == null) {
            request.setId(idGenerator.getAndIncrement());
            data.add(request);
            return request;
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(request.getId())) {
                data.set(i, request);
                return request;
            }
        }

        data.add(request);
        return request;
    }

    public void deleteById(Long id) {
        data.removeIf(item -> item.getId().equals(id));
    }

    public List<BorrowRequest> findByStatus(String status) {
        return data.stream()
                .filter(r -> r.getStatus() != null && r.getStatus().equalsIgnoreCase(status))
                .toList();
    }
}