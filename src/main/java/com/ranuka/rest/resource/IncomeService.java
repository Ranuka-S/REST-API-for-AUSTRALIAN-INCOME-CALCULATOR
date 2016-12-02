package com.ranuka.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;



import com.ranuka.rest.model.Income;
import com.ranuka.util.ausIncomCalculator.IncomeCalculator;

@Path("/AUSTax")
public class IncomeService {

	IncomeCalculator incomCal = new IncomeCalculator();
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response calculateIncome(Income income){
		
		double payAfteerTax = incomCal.calculator(income);
		String response = "your annual take home salary = "+payAfteerTax;
		return Response.status(200).entity(response).build();

	}

}
