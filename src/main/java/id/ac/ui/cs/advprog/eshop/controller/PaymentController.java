package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /*
     * GET /payment/detail
     * Show search payment page
     */
    @GetMapping("/detail")
    public String paymentDetailPage() {
        return "payment-detail";
    }

    /*
     * GET /payment/detail/{paymentId}
     * Show payment detail
     */
    @GetMapping("/detail/{paymentId}")
    public String paymentDetail(@PathVariable String paymentId, Model model) {

        Payment payment = paymentService.getPayment(paymentId);

        model.addAttribute("payment", payment);

        return "payment-detail-view";
    }

    /*
     * GET /payment/admin/list
     * Show all payments
     */
    @GetMapping("/admin/list")
    public String paymentList(Model model) {

        List<Payment> payments = paymentService.getAllPayments();

        model.addAttribute("payments", payments);

        return "payment-list";
    }

    /*
     * GET /payment/admin/detail/{paymentId}
     * Admin view payment with options
     */
    @GetMapping("/admin/detail/{paymentId}")
    public String paymentAdminDetail(@PathVariable String paymentId, Model model) {

        Payment payment = paymentService.getPayment(paymentId);

        model.addAttribute("payment", payment);

        return "payment-admin-detail";
    }

    /*
     * POST /payment/admin/set-status/{paymentId}
     * Admin approve / reject payment
     */
    @PostMapping("/admin/set-status/{paymentId}")
    public String setPaymentStatus(
            @PathVariable String paymentId,
            @RequestParam String status,
            Model model) {

        Payment payment = paymentService.getPayment(paymentId);

        paymentService.setStatus(payment, status);

        model.addAttribute("payment", payment);

        return "payment-admin-detail";
    }
}