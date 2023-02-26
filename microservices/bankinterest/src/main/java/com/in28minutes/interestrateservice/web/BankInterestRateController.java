package com.in28minutes.interestrateservice.web;

import com.in28minutes.interestrateservice.entity.BankInterestRate;
import com.in28minutes.interestrateservice.service.BankInterestService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rates")
@RequiredArgsConstructor
public class BankInterestRateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankInterestRateController.class);

    private final BankInterestService bankInterestService;

    @GetMapping("/")
    public List<BankInterestRate> getInterestRate() {
        return bankInterestService.findAll();
    }

    @GetMapping("/{bankName}")
    public BankInterestRate getInterestRate(@PathVariable String bankName) {
        return bankInterestService.findByBankName(bankName);
    }
}
