package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.OrderService;
import id.ac.ui.cs.advprog.eshop.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.*;

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

    @PostMapping("/create")
    public String createOrderPost(@RequestParam String author) {
        // Buat dummy product agar tidak kena validasi 'empty list' di model Order
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(2);
        products.add(product);

        Order order = new Order(UUID.randomUUID().toString(), products, System.currentTimeMillis(), author);
        orderService.createOrder(order);
        return "redirect:/order/history";
    }

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