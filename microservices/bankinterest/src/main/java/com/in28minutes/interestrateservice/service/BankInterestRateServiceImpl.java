package com.in28minutes.interestrateservice.service;

import com.in28minutes.interestrateservice.entity.BankInterestRate;
import com.in28minutes.interestrateservice.entity.BankInterestRateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional
public class BankInterestRateServiceImpl implements BankInterestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankInterestRateServiceImpl.class);

    private final BankInterestRateRepository bankInterestRateRepository;


    @Override
    public List<BankInterestRate> findAll() {

        List<BankInterestRate> bankInterestRateList = StreamSupport.stream(bankInterestRateRepository.findAll().spliterator(), false).collect(Collectors.toList());
        LOGGER.info("Number of entries {}",bankInterestRateList.size());
        return bankInterestRateList;
    }

    @Override
    public BankInterestRate findByBankName(String bankName) {
        return bankInterestRateRepository.findByBankName(bankName);
    }
}
