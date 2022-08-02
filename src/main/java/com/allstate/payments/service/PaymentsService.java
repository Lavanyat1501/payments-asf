package com.allstate.payments.service;

import com.allstate.payments.domain.CreditCardTransaction;

import java.util.List;

public interface PaymentsService {

    public List<CreditCardTransaction> getAllTransactions();
    public int countTransactions();
    public List<CreditCardTransaction> getAllTransactionsForCountry(String country);
    public List<CreditCardTransaction> getAllTransactionsForOrderId(String orderId);
    public CreditCardTransaction getTransactionById(Integer id);

}
