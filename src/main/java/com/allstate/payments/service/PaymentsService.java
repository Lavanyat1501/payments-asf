package com.allstate.payments.service;

import com.allstate.payments.domain.CreditCardTransaction;

import java.util.List;

public interface PaymentsService {

    public List<CreditCardTransaction> getAllTransactions();
    public int countTransactions();

}
