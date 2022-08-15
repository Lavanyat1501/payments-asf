package com.allstate.payments.integrationtests;

import com.allstate.payments.data.CreditCardTransactionRepository;
import com.allstate.payments.dtos.CreditCardTransactionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@AutoConfigureMockMvc
public class PaymentsTesting {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditCardTransactionRepository creditCardTransactionRepository;

    @Test
    public void checkNewTransactionsAreAddedToDatabase() throws Exception {
        CreditCardTransactionDTO newTransaction = new CreditCardTransactionDTO();
        newTransaction.setAmount(123.45);
        newTransaction.setCountry("AUS");
        newTransaction.setCurrency("EUR");
        newTransaction.setType("Mastercard");
        newTransaction.setOrderId("224466");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(newTransaction);

        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/payment")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        ResultActions result = mockMvc.perform(request)
                .andExpect(status().isOk());

        Mockito.verify(creditCardTransactionRepository)
                .save(newTransaction.toCreditCardTransaction());


    }


}
