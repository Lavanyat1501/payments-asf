package com.allstate.payments.service;

import com.allstate.payments.data.CreditCardTransactionRepository;
import com.allstate.payments.domain.CreditCardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CreditCardTransaction> getAllTransactionsForCountry(String country) {

//        return creditCardTransactionRepository.findAll()
//                .stream().filter( trans -> trans.getCountry().equals(country))
//                .collect(Collectors.toList());

        return creditCardTransactionRepository.findAllByCountry(country);
    }

    @Override
    public List<CreditCardTransaction> getAllTransactionsForOrderId(String orderId) {
        return creditCardTransactionRepository.findAllByOrderId(orderId);
    }

    @Override
    public CreditCardTransaction getTransactionById(Integer id) {
        return creditCardTransactionRepository.findById(id).get();
    }
}
