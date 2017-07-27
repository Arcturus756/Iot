package com.connector;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/read")
public class SheetReader {
	@GET
   
    public Response getMsg() {
  
		
	    StringBuilder output = new StringBuilder();
	    
	       output.append(
	            SheetValues.a + " " + SheetValues.b + " " + SheetValues.c + " " + SheetValues.d + " " + SheetValues.e);
	      
	    
       
        return Response.status(200).entity(output.toString()).build();
  
}
}