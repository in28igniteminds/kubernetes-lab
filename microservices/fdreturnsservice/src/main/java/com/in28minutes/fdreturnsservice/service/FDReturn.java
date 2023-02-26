package com.in28minutes.fdreturnsservice.service;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FDReturn {
    private String bankName;
    private BigDecimal interestRate;
    private BigDecimal yearlyReturn;
}
