package com.connector;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

@Path("/write")
public class SheetWriter {
	@GET
    @Path("/{value}")
    public Response getMsg(@PathParam("value") Boolean name) {
  
		Sheets service;
		 
		String spreadsheetId = "1TFraDvnmEHNCR-1sRIeKA9P0Q3fcWbLEHaVKl7hG5K4";
	    
	    ValueRange response= new ValueRange();
		
	    StringBuilder output = new StringBuilder();
	    
	    String range = "Sheet1!E1";
	    
	try {
	 service = Connect.getSheetsService();

		
		
		 Object a[] = {name};
		    List<List<Object>> values  = Arrays.asList(Arrays.asList(a));
		    ValueRange body = new ValueRange().setValues(values);
		    UpdateValuesResponse result = service.spreadsheets().values().update(spreadsheetId, range, body)
		        .setValueInputOption("RAW").execute();
			
		    
		    range = "Sheet1!A1:E";
		    response = service.spreadsheets().values().get(spreadsheetId, range).execute();
		    values = response.getValues();
		    
		    if (values == null || values.size() == 0) {
		      System.out.println("No data found.");
		    } else {

		    	
		      for (List row : values) {
		        // Print columns A and E, which correspond to indices 0 and 4.
		       output.append(
		             row.get(4));
		      }
		    }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

   
    
   
    return Response.status(200).entity(output.toString()).build();
        
  

}
}