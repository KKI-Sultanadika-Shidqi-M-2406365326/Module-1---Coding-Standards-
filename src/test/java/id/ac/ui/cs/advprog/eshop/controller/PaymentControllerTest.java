package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.service.PaymentService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PaymentController.class)
class PaymentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PaymentService paymentService;

    @Test
    void testPaymentDetailPage() throws Exception {

        mockMvc.perform(get("/payment/detail"))
                .andExpect(status().isOk())
                .andExpect(view().name("payment-detail"));
    }

    @Test
    void testPaymentDetailById() throws Exception {

        Payment payment = new Payment("1", null, "VOUCHER", null);

        when(paymentService.getPayment("1")).thenReturn(payment);

        mockMvc.perform(get("/payment/detail/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("payment-detail-view"));
    }

    @Test
    void testPaymentAdminList() throws Exception {

        List<Payment> payments = new ArrayList<>();

        when(paymentService.getAllPayments()).thenReturn(payments);

        mockMvc.perform(get("/payment/admin/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("payment-list"));
    }

    @Test
    void testPaymentAdminDetail() throws Exception {

        Payment payment = new Payment("1", null, "BANK_TRANSFER", null);

        when(paymentService.getPayment("1")).thenReturn(payment);

        mockMvc.perform(get("/payment/admin/detail/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("payment-admin-detail"));
    }

    @Test
    void testSetPaymentStatus() throws Exception {

        Payment payment = new Payment("1", null, "BANK_TRANSFER", null);

        when(paymentService.getPayment("1")).thenReturn(payment);

        mockMvc.perform(post("/payment/admin/set-status/1")
                        .param("status", "SUCCESS"))
                .andExpect(status().isOk())
                .andExpect(view().name("payment-admin-detail"));
    }
}