package com.in28minutes.interestrateservice.service;

import com.in28minutes.interestrateservice.entity.BankInterestRate;

import java.util.List;

public interface BankInterestService {
    List<BankInterestRate> findAll();
    BankInterestRate findByBankName(String bankName);
}
