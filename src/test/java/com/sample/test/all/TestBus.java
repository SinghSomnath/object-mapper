package com.sample.test.all;

import org.codehaus.jackson.map.ObjectMapper;



import io.restassured.response.Response;

public class TestBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ObjectMapper objectMapper = new ObjectMapper();
		String s = "https://www.redbus.in/Home/SolarSearch?search=Bangalore";


		
		
		Response res = RestUtil.fetchGetResponse(s);
		
		String s2 = RestUtil.fetchValueFromResponse(res, "$..response");
		 
		 s2 = s2.replaceAll("^\\[", "");
		 s2 = s2.replaceAll("]$", "");
		 
		System.out.println("Fetching value from response ...." + s2);
		
		
		
		SolrResponse solrResponse = null;
        try
        {
        	solrResponse = objectMapper.readValue(s2, SolrResponse.class);
        	System.out.println(solrResponse.getDocs()[0].getID());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		


	}

}
