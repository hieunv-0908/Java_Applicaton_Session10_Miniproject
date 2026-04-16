package re.java_application_session10_miniproject.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import re.java_application_session10_miniproject.dto.BorrowRequestDto;
import re.java_application_session10_miniproject.service.BorrowRequestService;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowRequestService borrowRequestService;

    @GetMapping("/{deviceId}")
    public String showBorrowForm(@PathVariable Long deviceId, Model model) {
        BorrowRequestDto dto = new BorrowRequestDto();
        dto.setDeviceId(deviceId);
        model.addAttribute("request", dto);
        return "student/borrow-form";
    }

    @PostMapping
    public String submitBorrowRequest(
            @Valid @ModelAttribute("request") BorrowRequestDto dto,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model) {
        
        if (result.hasErrors()) {
            return "student/borrow-form";
        }

        try {
            borrowRequestService.createBorrowRequest(dto);
            redirectAttributes.addFlashAttribute("success", "Đăng ký thành công");
            return "redirect:/devices";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "student/borrow-form";
        }
    }
}
