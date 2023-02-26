package com.in28minutes.fdreturnsservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class FDReturnsCalculatorRateServiceImpl implements FDReturnsCalculatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FDReturnsCalculatorRateServiceImpl.class);

    @Autowired
    private BankInterestServiceProxy bankInterestServiceProxy;

    @Override
    public FDReturn getInterestRate(String bankName) {
        return bankInterestServiceProxy.retrieveExchangeValue(bankName);
    }
}
