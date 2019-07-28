package com.rv.ms.controllers;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rv.ms.data.RepaymentRequest;
import com.rv.ms.data.RepaymentSchedule;
import com.rv.ms.data.Response;
import com.rv.ms.exceptions.IllegalRepaymentException;
import com.rv.ms.exceptions.ValidationException;
import com.rv.ms.services.CalcUtil;

/**
 * @author RanvijayS
 * @version 1.0
 * @Description Controllers
 */

@RestController
public class AmortzControllers {

	@Autowired
	CalcUtil calcUtility;
	
	/**
	 * @throws ValidationException 
	 * @Description REST Service /rv/amortz/generate
	 * @input application/json request
	 * @input application/json response
	 */
	@CrossOrigin
	@PostMapping(value = "/rv/amortz/generate")
	public Response generate(@RequestBody RepaymentRequest request) throws ValidationException, IllegalRepaymentException{
		Response response = null;
		response = new Response();
		    
			/*
		     * @ToDo - Request Validation need to be replace 
		     * with Hibernate validator, once full-fledged implementation required
		     * TempImplementaion
			 */
			if(this.validateRequest(request)){
				List<RepaymentSchedule> schedules = calcUtility.generate(request);
				response.setStatus("Success");
				LocalDateTime apiResponseTime = LocalDateTime.now();
				response.setResponseTime(apiResponseTime);
				response.setSchedules(schedules); 
			}
		return response;
	}
	
	//Temporary method
	private boolean validateRequest(RepaymentRequest request) throws ValidationException{
		
		if(request.getEmi_draw_on() == null || request.getEmi_draw_on() == ""){
			throw new ValidationException("BAD REQUEST: EMI Draw On Mandatory"); 
		}
		if(request.getTenor() == 0){
			throw new ValidationException("BAD REQUEST: Tenor is Mandatory"); 
		}
		if(request.getRate_annual_percent() == 0){
			throw new ValidationException("BAD REQUEST: Rate is Mandatory"); 
		}
		if(request.getInterest_type() == null){
			if(!request.getInterest_type().equalsIgnoreCase("FIXED-REDUCING")){
			    throw new ValidationException("BAD REQUEST: Interest Type should be FIXED-REDUCING "); 
			}
		}
		return true;
	}

}
