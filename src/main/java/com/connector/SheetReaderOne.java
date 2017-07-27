
	package com.connector;

	import javax.ws.rs.GET;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.core.Response;

	@Path("/readone")
	public class SheetReaderOne {
		@GET   
		@Path("/{val}")
	    public Response readOne(@PathParam("val") int val) {
	  
			Boolean output=null;
			
			switch(val){
			
	        case 1:  output = SheetValues.a;
	                 break;
	        case 2:  output = SheetValues.b;
	                 break;
	        case 3:  output = SheetValues.c;
	                 break;
	        case 4:  output = SheetValues.d;
	                 break;
	        case 5:  output = SheetValues.e;
	                 break;
			}
		   
		    
	       
	        return Response.status(200).entity(output.toString()).build();
	  
	}

	}


