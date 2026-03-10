package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.*;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

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
    }

    @Test
    void testAddPaymentVoucherSuccess() {

        Map<String,String> data = new HashMap<>();
        data.put("voucherCode","ESHOP1234ABC5678");

        Payment payment = new Payment("p1",order,"VOUCHER",data);

        doReturn(payment).when(paymentRepository).save(any(Payment.class));

        Payment result = paymentService.addPayment(order,"VOUCHER",data);

        assertEquals("SUCCESS", result.getStatus());
        assertEquals("SUCCESS", order.getStatus());
    }

    @Test
    void testAddPaymentBankTransferSuccess() {

        Map<String,String> data = new HashMap<>();
        data.put("bankName","BCA");
        data.put("referenceCode","INV123");

        Payment payment = new Payment("p2",order,"BANK_TRANSFER",data);

        doReturn(payment).when(paymentRepository).save(any(Payment.class));

        Payment result = paymentService.addPayment(order,"BANK_TRANSFER",data);

        assertEquals("SUCCESS", result.getStatus());
        assertEquals("SUCCESS", order.getStatus());
    }

    @Test
    void testGetPayment() {

        Payment payment = new Payment("p3",order,"VOUCHER",new HashMap<>());

        doReturn(payment).when(paymentRepository).findById("p3");

        Payment result = paymentService.getPayment("p3");

        assertEquals("p3", result.getId());
    }

    @Test
    void testGetAllPayments() {

        List<Payment> payments = new ArrayList<>();

        payments.add(new Payment("1",order,"VOUCHER",new HashMap<>()));
        payments.add(new Payment("2",order,"BANK_TRANSFER",new HashMap<>()));

        doReturn(payments).when(paymentRepository).findAll();

        List<Payment> result = paymentService.getAllPayments();

        assertEquals(2,result.size());
    }
}