package com.ranuka.util.ausIncomCalculator;

import com.ranuka.rest.model.Income;

public class IncomeCalculator {
	// this method is called by income service. check the income period and call respective method
	public double calculator(Income income){
		double takeHome = 0.0;
		
		switch(income.getFrequency()){
		case WEEKLY : takeHome = calculateWeeklyIncome(income);
		break;
		
		case FORTNIGHTLY : takeHome = calculateFortnightlyIncome(income);
		break;
		
		case MONTHLY : takeHome = calculateMonthlyIncome(income);
		break;
		
		case ANNUALLY : takeHome = calculateAnnuallyIncome(income);
		break;
		
		}
		
	
		return takeHome;
	}
	
	public double calculateWeeklyIncome(Income income){
		double grossIncome = income.getAmount()*52;
		return calculateTakeHomeAmount(grossIncome);
	}
	public double calculateFortnightlyIncome(Income income){
		double grossIncome = income.getAmount()*26;
		return calculateTakeHomeAmount(grossIncome);
	}
	public double calculateMonthlyIncome(Income income){
		double grossIncome = income.getAmount()*12;
		return calculateTakeHomeAmount(grossIncome);
	}
	public double calculateAnnuallyIncome(Income income){
		double grossIncome = income.getAmount();
		return calculateTakeHomeAmount(grossIncome);
	}
	
	//actually calculate take home income
	public double calculateTakeHomeAmount(double annuallIncomeBeforTax) {
		
		double taxableAmount = 0.0;
		double takeHome = 0.0;
		double taxAmount = 0.0;
		
		if(annuallIncomeBeforTax <= 18200){
			takeHome = annuallIncomeBeforTax;
		}else if((annuallIncomeBeforTax > 18200)&(annuallIncomeBeforTax <= 37000)){
			
			takeHome = 18200;
			taxableAmount = annuallIncomeBeforTax - 18200;
			taxAmount =calculateTax(taxableAmount, 19);
			takeHome = takeHome + (taxableAmount - taxAmount);
			
		}else if((annuallIncomeBeforTax > 37000)&(annuallIncomeBeforTax <= 87000)){
			takeHome = 33428;
			taxableAmount = annuallIncomeBeforTax - 37000;
			taxAmount = calculateTax(taxableAmount, 32.5);
			takeHome = takeHome + (taxableAmount - taxAmount);
			
		}
		else if((annuallIncomeBeforTax > 87000)&(annuallIncomeBeforTax <= 180000)){
			takeHome = 67178;
			taxableAmount = annuallIncomeBeforTax - 87000;
			taxAmount = calculateTax(taxableAmount, 37);
			takeHome = takeHome + (taxableAmount - taxAmount);
			
		}	else if(annuallIncomeBeforTax > 180000){
			takeHome = 125768;
			taxableAmount = annuallIncomeBeforTax - 180000;
			taxAmount = calculateTax(taxableAmount, 45);
			takeHome = takeHome + (taxableAmount - taxAmount);
			
		}
		
		
		
		return takeHome;
	}
	public double calculateTax(double income, double taxRate){
		double tax = (income/100)*taxRate;
		
		return tax;
	}

}
