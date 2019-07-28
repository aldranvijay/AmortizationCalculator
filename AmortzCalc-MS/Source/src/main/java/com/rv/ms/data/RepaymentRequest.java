package com.rv.ms.data;

public class RepaymentRequest {
    	private double loan_amount;
	    private double disbursement_amount;
	    private double sanction_amount;
	    private String emi_draw_on;
	    private int tenor;
	    private double rate_annual_percent;
	    private String repsch_type;
	    private String intrate_basis;
	    private String days_per_month;
	    private String days_per_year;
	    private String interest_type;
	    private String emi_due_date;
	    private int principal_grace;
	    private int interest_grace;
	    private boolean is_capitalize;
	    private boolean is_compounding;

	    public void setLoan_amount(double loan_amount){
	        this.loan_amount = loan_amount;
	    }
	    public double getLoan_amount(){
	        return this.loan_amount;
	    }
	    public void setDisbursement_amount(double disbursement_amount){
	        this.disbursement_amount = disbursement_amount;
	    }
	    public double getDisbursement_amount(){
	        return this.disbursement_amount;
	    }
	    public void setSanction_amount(double sanction_amount){
	        this.sanction_amount = sanction_amount;
	    }
	    public double getSanction_amount(){
	        return this.sanction_amount;
	    }
	    public void setEmi_draw_on(String emi_draw_on){
	        this.emi_draw_on = emi_draw_on;
	    }
	    public String getEmi_draw_on(){
	        return this.emi_draw_on;
	    }
	    public void setTenor(int tenor){
	        this.tenor = tenor;
	    }
	    public int getTenor(){
	        return this.tenor;
	    }
	    public void setRate_annual_percent(double rate_annual_percent){
	        this.rate_annual_percent = rate_annual_percent;
	    }
	    public double getRate_annual_percent(){
	        return this.rate_annual_percent;
	    }
	    public void setRepsch_type(String repsch_type){
	        this.repsch_type = repsch_type;
	    }
	    public String getRepsch_type(){
	        return this.repsch_type;
	    }
	    public void setIntrate_basis(String intrate_basis){
	        this.intrate_basis = intrate_basis;
	    }
	    public String getIntrate_basis(){
	        return this.intrate_basis;
	    }
	    public void setDays_per_month(String days_per_month){
	        this.days_per_month = days_per_month;
	    }
	    public String getDays_per_month(){
	        return this.days_per_month;
	    }
	    public void setDays_per_year(String days_per_year){
	        this.days_per_year = days_per_year;
	    }
	    public String getDays_per_year(){
	        return this.days_per_year;
	    }
	    public void setInterest_type(String interest_type){
	        this.interest_type = interest_type;
	    }
	    public String getInterest_type(){
	        return this.interest_type;
	    }
	    public void setEmi_due_date(String emi_due_date){
	        this.emi_due_date = emi_due_date;
	    }
	    public String getEmi_due_date(){
	        return this.emi_due_date;
	    }
	    public void setPrincipal_grace(int principal_grace){
	        this.principal_grace = principal_grace;
	    }
	    public int getPrincipal_grace(){
	        return this.principal_grace;
	    }
	    public void setInterest_grace(int interest_grace){
	        this.interest_grace = interest_grace;
	    }
	    public int getInterest_grace(){
	        return this.interest_grace;
	    }
	    public void setIs_capitalize(boolean is_capitalize){
	        this.is_capitalize = is_capitalize;
	    }
	    public boolean getIs_capitalize(){
	        return this.is_capitalize;
	    }
	    public void setIs_compounding(boolean is_compounding){
	        this.is_compounding = is_compounding;
	    }
	    public boolean getIs_compounding(){
	        return this.is_compounding;
	    }
}
