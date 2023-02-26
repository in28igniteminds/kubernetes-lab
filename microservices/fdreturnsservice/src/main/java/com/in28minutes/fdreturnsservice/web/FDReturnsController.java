package com.in28minutes.fdreturnsservice.web;

import com.in28minutes.fdreturnsservice.service.FDReturn;
import com.in28minutes.fdreturnsservice.service.FDReturnsCalculatorService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fdreturns/")
@RequiredArgsConstructor
public class FDReturnsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FDReturnsController.class);

    private final FDReturnsCalculatorService FDReturnsCalculatorService;


    @GetMapping("from/{bankName}/for/{amount}")
    public FDReturn getInterestRate(@PathVariable String bankName, @PathVariable double amount) {
        FDReturn fdReturn = FDReturnsCalculatorService.getInterestRate(bankName);
        BigDecimal returns = (BigDecimal.valueOf(amount).multiply(fdReturn.getInterestRate())).divide(BigDecimal.valueOf(100));
        fdReturn.setYearlyReturn(returns);
        return fdReturn;
    }
}
