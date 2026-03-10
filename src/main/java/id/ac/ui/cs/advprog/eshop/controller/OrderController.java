package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.service.OrderService;
import id.ac.ui.cs.advprog.eshop.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    /*
     * GET /order/create
     * Show create order form
     */
    @GetMapping("/create")
    public String createOrderPage() {
        return "create-order";
    }

    /*
     * GET /order/history
     * Show form to input author name
     */
    @GetMapping("/history")
    public String orderHistoryPage() {
        return "order-history";
    }

    /*
     * POST /order/history
     * Show orders by author
     */
    @PostMapping("/history")
    public String orderHistorySubmit(@RequestParam("author") String author, Model model) {

        List<Order> orders = orderService.findAllByAuthor(author);

        model.addAttribute("orders", orders);

        return "order-history-list";
    }

    /*
     * GET /order/pay/{orderId}
     * Show payment page for an order
     */
    @GetMapping("/pay/{orderId}")
    public String payOrderPage(@PathVariable String orderId, Model model) {

        Order order = orderService.findById(orderId);

        model.addAttribute("order", order);

        return "order-pay";
    }

    /*
     * POST /order/pay/{orderId}
     * Process payment
     */
    @PostMapping("/pay/{orderId}")
    public String payOrderSubmit(
            @PathVariable String orderId,
            @RequestParam String method,
            @RequestParam(required = false) String voucherCode,
            @RequestParam(required = false) String bankName,
            @RequestParam(required = false) String referenceCode,
            Model model) {

        Order order = orderService.findById(orderId);

        Map<String,String> paymentData = new HashMap<>();

        if ("VOUCHER".equals(method)) {
            paymentData.put("voucherCode", voucherCode);
        }

        if ("BANK_TRANSFER".equals(method)) {
            paymentData.put("bankName", bankName);
            paymentData.put("referenceCode", referenceCode);
        }

        Payment payment = paymentService.addPayment(order, method, paymentData);

        model.addAttribute("payment", payment);

        return "payment-result";
    }
}