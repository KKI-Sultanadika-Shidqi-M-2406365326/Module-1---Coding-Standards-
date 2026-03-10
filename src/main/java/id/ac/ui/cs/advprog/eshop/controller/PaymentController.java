package id.ac.ui.cs.advprog.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/detail")
    public String paymentDetailPage() {
        return "payment-detail";
    }

    @GetMapping("/admin/list")
    public String paymentListPage() {
        return "payment-list";
    }

}