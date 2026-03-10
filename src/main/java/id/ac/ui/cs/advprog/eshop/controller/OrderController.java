package id.ac.ui.cs.advprog.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/create")
    public String createOrderPage() {
        return "create-order";
    }

    @GetMapping("/history")
    public String orderHistoryPage() {
        return "order-history";
    }
}