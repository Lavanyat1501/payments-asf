package com.allstate.payments.data;

import com.allstate.payments.domain.CreditCardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardTransactionRepository extends JpaRepository<CreditCardTransaction, Integer> {
}
