package com.rv.ms.data;

import java.time.LocalDateTime;
import java.util.List;

public class Response {

	private String status;
	private String errorMsg;
	private LocalDateTime responseTime;
	private List<RepaymentSchedule> schedules;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public LocalDateTime getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(LocalDateTime responseTime) {
		this.responseTime = responseTime;
	}
	public List<RepaymentSchedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<RepaymentSchedule> schedules) {
		this.schedules = schedules;
	}
	
	
	
}
