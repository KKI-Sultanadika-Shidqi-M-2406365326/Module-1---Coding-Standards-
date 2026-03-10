package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Order order, String method, Map<String,String> paymentData) {

        Payment payment = new Payment(
                UUID.randomUUID().toString(),
                order,
                method,
                paymentData
        );

        if ("VOUCHER".equals(method)) {

            String code = paymentData.get("voucherCode");

            if (isValidVoucher(code)) {
                payment.setStatus("SUCCESS");
                order.setStatus("SUCCESS");
            } else {
                payment.setStatus("REJECTED");
                order.setStatus("FAILED");
            }
        }

        if ("BANK_TRANSFER".equals(method)) {

            String bankName = paymentData.get("bankName");
            String referenceCode = paymentData.get("referenceCode");

            boolean validTransfer = !isEmpty(bankName) && !isEmpty(referenceCode);

            if (validTransfer) {
                payment.setStatus("SUCCESS");
                order.setStatus("SUCCESS");
            } else {
                payment.setStatus("REJECTED");
                order.setStatus("FAILED");
            }
        }

        paymentRepository.save(payment);
        return payment;
    }

    @Override
    public Payment setStatus(Payment payment, String status) {

        payment.setStatus(status);

        if ("SUCCESS".equals(status)) {
            payment.getOrder().setStatus("SUCCESS");
        }

        if ("REJECTED".equals(status)) {
            payment.getOrder().setStatus("FAILED");
        }

        return payment;
    }

    @Override
    public Payment getPayment(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    private boolean isValidVoucher(String code) {

        if (code == null) return false;
        if (code.length() != 16) return false;
        if (!code.startsWith("ESHOP")) return false;

        int digits = 0;

        for (char c : code.toCharArray()) {
            if (Character.isDigit(c)) digits++;
        }

        return digits == 8;
    }

    private boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }
}