package com.rv.ms.data;

public class RepaymentSchedule {
	private String installment_no;
    private String due_date;
    private String emi;
    private String interest;
    private String principal;
    private String principal_os;
    private String days_per_month;
    private String days_per_year;
    private String days_in_month_actual;
    private String cumulative_days_actual;
    private String discounting_factor;

    public void setInstallment_no(String installment_no){
        this.installment_no = installment_no;
    }
    public String getInstallment_no(){
        return this.installment_no;
    }
    public void setDue_date(String due_date){
        this.due_date = due_date;
    }
    public String getDue_date(){
        return this.due_date;
    }
    public void setEmi(String emi){
        this.emi = emi;
    }
    public String getEmi(){
        return this.emi;
    }
    public void setInterest(String interest){
        this.interest = interest;
    }
    public String getInterest(){
        return this.interest;
    }
    public void setPrincipal(String principal){
        this.principal = principal;
    }
    public String getPrincipal(){
        return this.principal;
    }
    public void setPrincipal_os(String principal_os){
        this.principal_os = principal_os;
    }
    public String getPrincipal_os(){
        return this.principal_os;
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
    public void setDays_in_month_actual(String days_in_month_actual){
        this.days_in_month_actual = days_in_month_actual;
    }
    public String getDays_in_month_actual(){
        return this.days_in_month_actual;
    }
    public void setCumulative_days_actual(String cumulative_days_actual){
        this.cumulative_days_actual = cumulative_days_actual;
    }
    public String getCumulative_days_actual(){
        return this.cumulative_days_actual;
    }
    public void setDiscounting_factor(String discounting_factor){
        this.discounting_factor = discounting_factor;
    }
    public String getDiscounting_factor(){
        return this.discounting_factor;
    }
}
