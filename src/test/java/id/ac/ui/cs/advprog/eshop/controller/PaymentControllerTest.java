package id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PaymentController.class)
public class PaymentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testPaymentDetailPage() throws Exception {

        mockMvc.perform(get("/payment/detail"))
                .andExpect(status().isOk())
                .andExpect(view().name("payment-detail"));
    }
}