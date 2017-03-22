package com.ranuka.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.ranuka.rest.model.Income;
import com.ranuka.util.ausIncomCalculator.IncomeCalculator;

@Path("/rest/AUSTaxv2")
public class IncomeServiceV2 {

	IncomeCalculator incomCal = new IncomeCalculator();
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response calculateIncome(Income income){
		
		double payAfteerTax = incomCal.calculator(income);
		String response = "Your annual take home salary V2 = "+payAfteerTax;
		Response httpResponse = Response.status(200).entity(response).type(MediaType.TEXT_PLAIN).header("Access-Control-Allow-Origin", "*").build();
		return httpResponse;

	}
	
	@OPTIONS
	@Path("{path : .*}")
	public Response options() {
	    return Response.ok("")
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "2000")
	            .build();
	}
}
