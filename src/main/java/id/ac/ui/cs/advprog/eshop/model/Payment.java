package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Payment {

    private final String id;
    private final String method;
    private String status;
    private final Map<String,String> paymentData;
    private final Order order;

    public Payment(String id, Order order, String method, Map<String,String> paymentData) {
        this.id = id;
        this.order = order;
        this.method = method;
        this.paymentData = paymentData;
    }
}