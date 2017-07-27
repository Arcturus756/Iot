package com.connector;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

public class SheetService implements Runnable {

	
	public void run() {

		
			

			Sheets service ;
			String spreadsheetId = "1TFraDvnmEHNCR-1sRIeKA9P0Q3fcWbLEHaVKl7hG5K4";
			try {
				service = Connect.getSheetsService();
			
			ValueRange response ;
			String range ;

			while (true) {
			
				
				
				response = new ValueRange();
				
				List<List<Object>> values;
				

				range = "Sheet1!A1:E";
				response = service.spreadsheets().values().get(spreadsheetId, range).execute();
				values = response.getValues();

				for (List row : values) {
					// Print columns A and E, which correspond to indices 0 and
					// 4.

					SheetValues.a = Boolean.parseBoolean((String) row.get(0));
					SheetValues.b = Boolean.parseBoolean((String) row.get(1));
					SheetValues.c = Boolean.parseBoolean((String) row.get(2));
					SheetValues.d = Boolean.parseBoolean((String) row.get(3));
					SheetValues.e = Boolean.parseBoolean((String) row.get(4));

				}
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
