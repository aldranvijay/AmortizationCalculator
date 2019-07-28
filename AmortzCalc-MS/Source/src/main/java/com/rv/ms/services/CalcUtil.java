package com.rv.ms.services;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.rv.ms.data.RepaymentRequest;
import com.rv.ms.data.RepaymentSchedule;
import com.rv.ms.exceptions.IllegalRepaymentException;

/**
 * @author RanvijayS
 * @version 1.0
 * @Description Utility class to having methods to generate repayment schedules
 */
@Component
public class CalcUtil {

	
	public List<RepaymentSchedule> generate(RepaymentRequest request) throws IllegalRepaymentException{
		 List<RepaymentSchedule> schedules = new LinkedList<RepaymentSchedule>();
		 LocalDate lastDueDate = LocalDate.now();
		 try{
		 double openingBalance = request.getEmi_draw_on().equalsIgnoreCase("DISB-AMOUNT")?request.getDisbursement_amount():request.getSanction_amount();
		 double equatedEMI = 0;
		 if(!request.getIs_capitalize() && !request.getIs_compounding()){
		        equatedEMI = this.getEquatedEMI(openingBalance, request.getRate_annual_percent(), request.getTenor());
		 }
		 System.out.println("equatedEMI : "+equatedEMI);
		 double interest = 0;
		 double principal = 0;
		 int cumulativeDays = 0;
		 YearMonth yearMonth = YearMonth.now();
		
		 for(int installmentNo = 1; installmentNo <= request.getTenor(); installmentNo++){
			RepaymentSchedule schedule = new RepaymentSchedule();
			schedule.setInstallment_no(String.valueOf(installmentNo));
			lastDueDate = this.getDueDate(lastDueDate);
	       	schedule.setDue_date(lastDueDate.format(DateTimeFormatter.ISO_DATE));
	       	interest = this.getInterest(openingBalance, request.getRate_annual_percent());
	    	if(installmentNo == request.getTenor()){
	       		equatedEMI = openingBalance + interest;
	       	}
	       	schedule.setEmi(String.valueOf(equatedEMI));
	       	schedule.setInterest(String.valueOf(interest));
	       	principal = this.getPrincipal(equatedEMI, interest);
	       	schedule.setPrincipal(String.valueOf(principal));  
	       	openingBalance = this.getPrincipalOS(openingBalance, principal);
	       	schedule.setPrincipal_os(String.valueOf(openingBalance)); 
	       	yearMonth = yearMonth.of(lastDueDate.getYear(), lastDueDate.getMonth());
	       	schedule.setDays_per_month(String.valueOf(request.getDays_per_month().equalsIgnoreCase("actual") ? yearMonth.lengthOfMonth() : request.getDays_per_month())); 
	       	schedule.setDays_in_month_actual(String.valueOf(yearMonth.lengthOfMonth()));
	       	schedule.setDays_per_year(String.valueOf(request.getDays_per_year().equalsIgnoreCase("actual") ? yearMonth.lengthOfYear() : request.getDays_per_year())); 
	       	cumulativeDays += yearMonth.lengthOfMonth();
	       	schedule.setCumulative_days_actual(String.valueOf(cumulativeDays)); 
	       	schedule.setDiscounting_factor(String.valueOf(this.getDiscountingFactor(request.getRate_annual_percent(), cumulativeDays))); //ToBe Confirm
	       	schedules.add(schedule); 
		 }
		 }catch(Exception ex){
			 throw new IllegalRepaymentException("IllegalRepaymentException : "+ex.getMessage());
		 }
		 return schedules;
	}
	
	private LocalDate getDueDate(LocalDate lastDueDate){
		return lastDueDate.plusMonths(1);
	}
	
	private double getEquatedEMI(double amount, double rate, int term){
    	double emi = Math.round((amount * ((rate/12)/100) * (Math.pow((1+((rate/12)/100)),term) / ((Math.pow((1+((rate/12)/100)),term))-1))) * 100.0) / 100.0;
    	System.out.println("getEquatedEMI - emi : "+emi); 
		return emi;
	}
    
    private double getInterest(double openingBalance, double intRate){
		return Math.round((openingBalance * ((intRate/12)/100)) * 100.0)/100.0;
	}
    
    private double getPrincipal(double emi, double interest){
		return Math.round((emi - interest)*100.0)/100.0;
	}
    
    private double getPrincipalOS(double openingBalance, double principal){
		return Math.round((openingBalance - principal)*100.0)/100.0; 
	}
    
    private double getDiscountingFactor(double intRate, int cumulativeDays){
    	return 1 / (1 * (Math.pow((1+((intRate/12)/100)),(cumulativeDays/30))));
	}
    
}
