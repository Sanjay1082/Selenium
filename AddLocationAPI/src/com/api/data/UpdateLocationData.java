package com.api.data;

import com.api.request.AddLocationAPIRequest;

public class UpdateLocationData {

	public static String getdata()
	{
		String placeid = AddLocationAPIRequest.placeid;
		return "{\r\n" + 
				"\"place_id\":\""+placeid+"\",\r\n" + 
				"\"address\":\"71 Summer walk updated, USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"";
	}
}
