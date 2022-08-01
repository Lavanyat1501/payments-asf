package com.allstate.payments.control;

import com.allstate.payments.domain.CreditCardTransaction;
import com.allstate.payments.service.PaymentsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/api/payment")
public class PaymentsController {

    PaymentsService paymentsService;

    @GetMapping()
    public List<CreditCardTransaction> getAll() {
        return paymentsService.getAllTransactions();
    }

    @GetMapping("/volume")
    public Map<String, String> getNumberOfPayments() {
        Integer volume = paymentsService.countTransactions();
        Map<String, String> results = new HashMap<>();
        results.put("volume", volume.toString());
        return results;
    }
}
