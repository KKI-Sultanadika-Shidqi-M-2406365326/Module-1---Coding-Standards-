package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {

    PaymentRepository paymentRepository;
    Payment payment;

    @BeforeEach
    void setUp() {

        paymentRepository = new PaymentRepository();

        List<Product> products = new ArrayList<>();

        Product product = new Product();
        product.setProductId("p1");
        product.setProductName("Sampo");
        product.setProductQuantity(2);

        products.add(product);

        Order order = new Order(
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
    void testSavePayment() {

        Payment result = paymentRepository.save(payment);

        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testFindPaymentById() {

        paymentRepository.save(payment);

        Payment result = paymentRepository.findById("payment1");

        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testFindAllPayments() {

        paymentRepository.save(payment);

        List<Payment> payments = paymentRepository.findAll();

        assertEquals(1, payments.size());
    }
}