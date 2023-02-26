package com.in28minutes.interestrateservice.entity;

import org.springframework.data.repository.CrudRepository;

public interface BankInterestRateRepository extends CrudRepository<BankInterestRate, Long> {
    BankInterestRate findByBankName(String bankName);
}
