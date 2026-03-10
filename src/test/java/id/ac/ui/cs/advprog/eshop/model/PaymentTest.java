package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    Payment payment;
    Order order;

    @BeforeEach
    void setUp() {

        List<Product> products = new ArrayList<>();

        Product product = new Product();
        product.setProductId("p1");
        product.setProductName("Sampo");
        product.setProductQuantity(2);

        products.add(product);

        order = new Order(
                "order1",
                products,
                1708560000L,
                "Safira Sudrajat"
        );

        Map<String,String> paymentData = new HashMap<>();
        paymentData.put("voucherCode","ESHOP1234ABC5678");

        payment = new Payment(
                "payment1",
                order,
                "VOUCHER",
                paymentData
        );
    }

    @Test
    void testPaymentId() {
        assertEquals("payment1", payment.getId());
    }

    @Test
    void testPaymentMethod() {
        assertEquals("VOUCHER", payment.getMethod());
    }

    @Test
    void testPaymentOrder() {
        assertEquals(order, payment.getOrder());
    }

    @Test
    void testPaymentData() {
        assertEquals("ESHOP1234ABC5678",
                payment.getPaymentData().get("voucherCode"));
    }
}