package com.in28minutes.interestrateservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class BankInterestRate {

	@Id
	private Long id;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "interest_rate")
	private BigDecimal interestRate;


	public BankInterestRate() {

	}

	public BankInterestRate(Long id, String bankName, BigDecimal interestRate) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.interestRate = interestRate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BankInterestRate{" +
				"id=" + id +
				", bankName='" + bankName + '\'' +
				", interestRate=" + interestRate +
				'}';
	}
}
