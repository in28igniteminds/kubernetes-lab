package com.in28minutes.fdreturnsservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="bank-interest", url="${BANK_INTEREST_SERVICE_HOST:http://localhost}:8000")
public interface BankInterestServiceProxy {
    @GetMapping("/rates/{bankName}")
    public FDReturn retrieveExchangeValue(@PathVariable("bankName") String bankName);
}
