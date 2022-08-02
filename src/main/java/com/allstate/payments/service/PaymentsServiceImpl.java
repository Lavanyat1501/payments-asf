package com.allstate.payments.service;

import com.allstate.payments.data.CreditCardTransactionRepository;
import com.allstate.payments.domain.CreditCardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentsServiceImpl implements PaymentsService{

    @Autowired
    private CreditCardTransactionRepository creditCardTransactionRepository;

    @Override
    public List<CreditCardTransaction> getAllTransactions() {
        return creditCardTransactionRepository.findAll();
    }

    @Override
    public int countTransactions() {
        return creditCardTransactionRepository.findAll().size();
    }
}
