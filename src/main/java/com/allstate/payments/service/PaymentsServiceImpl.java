package com.allstate.payments.service;

import com.allstate.payments.domain.CreditCardTransaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentsServiceImpl implements PaymentsService{
    @Override
    public List<CreditCardTransaction> getAllTransactions() {
        CreditCardTransaction cct1 = new CreditCardTransaction(1,15.27,"USA","USD", LocalDate.now(),
                "Order 1",1,0.2,"Visa");
        CreditCardTransaction cct2 = new CreditCardTransaction(2,25.27,"USA","USD", LocalDate.of(2022,7,31),
                "Order 2",1,0.2,"Visa");
        List<CreditCardTransaction> transactionList= new ArrayList<>();
        transactionList.add(cct1);
        transactionList.add(cct2);
        return transactionList;
    }

    @Override
    public int countTransactions() {
        return 192;
    }
}
