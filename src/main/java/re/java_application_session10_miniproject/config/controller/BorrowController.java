package re.java_application_session10_miniproject.config.controller;

import jakarta.validation.Valid;
import org.example.itlab.dto.BorrowRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

    @GetMapping("/{deviceId}")
    public String showBorrowForm(@PathVariable Long deviceId, Model model) {
        BorrowRequestDto dto = new BorrowRequestDto();
        dto.setDeviceId(deviceId);
        model.addAttribute("borrowRequestDto", dto);
        return "student/borrow-form";
    }

    @PostMapping("/submit")
    public String processBorrow(@Valid @ModelAttribute("borrowRequestDto") BorrowRequestDto dto,
                                BindingResult result,
                                RedirectAttributes ra) {
        // Nếu có lỗi validation
        if (result.hasErrors()) {
            return "student/borrow-form";
        }

        // Giả sử lưu thành công (phần này Dương sẽ xử lý ở Service)
        ra.addFlashAttribute("message", "Đăng ký mượn thành công!");
        return "redirect:/devices";
    }
}