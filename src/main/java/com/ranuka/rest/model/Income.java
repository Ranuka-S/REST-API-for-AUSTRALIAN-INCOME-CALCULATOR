package com.ranuka.rest.model;

public class Income {
	public enum Frequency{
		WEEKLY, FORTNIGHTLY, MONTHLY, ANNUALLY
	}
private double amount;
private Frequency frequency;

public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Frequency getFrequency() {
	return frequency;
}
public void setFrequency(Frequency frequency) {
	this.frequency = frequency;
}

}
