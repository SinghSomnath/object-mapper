package com.sample.test.all;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

//import com.jayway.restassured.RestAssured;
//import com.jayway.restassured.response.Header;
//import com.jayway.restassured.response.Response;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class RestUtil {

	public static String responseData = "";
	public static Response response = null;
	public static String respons="";

	protected static final Logger log = Logger.getLogger(RestUtil.class);

	/**
	 * @param uri
	 * @param request
	 * @return String
	 * @Description Used to send HTTP_POST request 
	 */
	public static String sendPOSTRequest(String uri, String request) {
		try{

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				log.info("Request is : "+ request+"\n");

				response = RestAssured.given().and().contentType("application/json").body(request).when().post(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI and Request Can not be null");
			}
		}catch(Exception e){
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @return String
	 * @Description Used to send HTTP_PUT request
	 */
	public static String sendPUTRequest(String uri, String request) {
		try {

			if(uri!=null && request !=null){
				log.info("Requested URI : " + uri);
				log.info("Request body is : " + request);

				response = RestAssured.given().and().contentType("application/json").body(request).when().put(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n" + responseData + "\n");
			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @return String
	 * @Description Used to get HTTP_GET response
	 */
	public static String getGETResponse(String uri) {
		try {

			if(uri!=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().contentType("application/json").when().get(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}



	/**
	 * @param uri
	 * @return String
	 * @Description Used to get HTTP_GET response
	 */
	public static Response getGETResponse1(String uri) {
		try {

			if(uri!=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().contentType("application/json").when().get(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}

	/**
	 * @param uri
	 * @return String
	 * @Description Used to delete resource By HTTP_Delete
	 */
	public static String doDELETEResource(String uri) {
		try {

			if(uri!=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().and().contentType("application/json").when().delete(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @param authorization
	 * @param basiAuthInBase64
	 * @return String
	 * @Description Used to send HTTP_POST request 
	 */
	public static String sendPOSTRequest(String uri, String request,
			String authorization, String basiAuthInBase64) {
		try{

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				log.info("Request is : "+ request+"\n");

				response = RestAssured.given().header(authorization, basiAuthInBase64)
						.and().contentType("application/json").body(request).when().post(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		}catch(Exception e){
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @param authorization
	 * @param basiAuthInBase64
	 * @return String
	 * @Description Used to send HTTP_PUT request
	 */
	public static String sendPUTRequest(String uri, String request,
			String authorization, String basiAuthInBase64) {
		try {

			if(uri!=null && request !=null){
				log.info("Requested URI : " + uri);
				log.info("Request body is : " + request);

				response = RestAssured.given().header(authorization, basiAuthInBase64)
						.and().contentType("application/json").body(request).when().put(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n" + responseData + "\n");
			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param authorization
	 * @param basiAuthInBase64
	 * @return String
	 * @Description Used to get HTTP_GET response
	 */
	public static String getGETResponse(String uri, String authorization,
			String basiAuthInBase64) {
		try {

			if(uri!=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().header(authorization, basiAuthInBase64)
						.and().contentType("application/json").when().get(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param authorization
	 * @param basiAuthInBase64
	 * @return String
	 * @Description Used to delete resource By HTTP_Delete
	 */
	public static String doDELETEResource(String uri, String authorization,
			String basiAuthInBase64) {
		try {

			if(uri!=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().header(authorization, basiAuthInBase64)
						.and().contentType("application/json").when().delete(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @param authorization
	 * @param basiAuthInBase64
	 * @return String
	 * @Description Used to send HTTP_POST JSON request From File
	 */
	public static String sendHTTPPOSTRequestFromJSONFile(String uri, String filePath,
			String authorization, String basiAuthInBase64) {
		try {

			if(uri!=null && filePath !=null){
				log.info("Requested URI : "+uri);
				JSONParser parser = new JSONParser();
				JSONObject object = (JSONObject) parser.parse(new FileReader(filePath));

				String jsonRequest = object.toJSONString();
				log.info("Request body is : "+ jsonRequest);

				response = RestAssured.given().header(authorization, basiAuthInBase64)
						.and().contentType("application/json").body(jsonRequest).when().post(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI and filePath Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @param authorization
	 * @param basiAuthInBase64
	 * @return String
	 * @Description Used to send HTTP_PUT JSON request From File
	 */
	public static String sendHTTPPUTRequestFromJSONFile(String uri, String filePath,
			String authorization, String basiAuthInBase64) {
		try {

			if(uri!=null && filePath !=null){
				log.info("Requested URI : "+uri);
				JSONParser parser = new JSONParser();
				JSONObject object = (JSONObject) parser.parse(new FileReader(filePath));

				String jsonRequest = object.toJSONString();
				log.info("Request body is : "+ jsonRequest);

				response = RestAssured.given().header(authorization, basiAuthInBase64)
						.and().contentType("application/json").body(jsonRequest).when().put(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI and filePath Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @param authorization
	 * @param basiAuthInBase64
	 * @return String
	 * @Description Used to send HTTP_POST Array JSON request From File
	 */
	public static String sendHTTPPOSTArrayRequestFromJSONFile(String uri, String request,
			String authorization, String basiAuthInBase64) {
		try {

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				JSONParser parser = new JSONParser();
				JSONArray object = (JSONArray) parser.parse(new FileReader(request));

				String jsonRequest = object.toString();
				log.info("Request body is : "+ jsonRequest);

				response = RestAssured.given().header(authorization, basiAuthInBase64)
						.and().contentType("application/json").body(jsonRequest).when().post(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @param authorization
	 * @param basiAuthInBase64
	 * @return String
	 * @Description Used to send HTTP_PUT Array JSON request From File
	 */
	public static String sendHTTPPUTArrayRequestFromJSONFile(String uri, String request,
			String authorization, String basiAuthInBase64) {
		try {

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				JSONParser parser = new JSONParser();
				JSONArray object = (JSONArray) parser.parse(new FileReader(request));

				String jsonRequest = object.toString();
				log.info("Request body is : "+ jsonRequest);

				response = RestAssured.given().header(authorization, basiAuthInBase64)
						.and().contentType("application/json").body(jsonRequest).when().put(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @return Response
	 * @Description Used to send HTTP_POST request 
	 */
	public static Response sendHTTPPOSTRequest(String uri, String request) {
		try{

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				log.info("Request is : "+ request+"\n");

				response = RestAssured.given().and().contentType("application/json").body(request).when().post(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI and Request Can not be null");
			}
		}catch(Exception e){
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}

	/**
	 * @param uri
	 * @param request
	 * @return Response
	 * @Description Used to send HTTP_PUT request 
	 */
	public static Response sendHTTPPUTRequest(String uri, String request) {
		try {

			if(uri!=null && request !=null){
				log.info("Requested URI : " + uri);
				log.info("Request body is : " + request);

				response = RestAssured.given().and().contentType("application/json").body(request).when().put(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n" + responseData + "\n");
			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}

	/**
	 * @param uri
	 * @return Response
	 * @Description Used to get HTTP_GET response 
	 */
	public static Response getHTTPGETResponse(String uri) {
		try {

			if(uri!=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().and().contentType("application/json").when().get(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}

	/**
	 * @param uri
	 * @return Response
	 * @Description Used to delete resource By HTTP_Delete
	 */
	public static Response doHTTPDELETEResource(String uri) {
		try {

			if(uri!=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().and().contentType("application/json").when().delete(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}

	/**
	 * @param uri
	 * @param request
	 * @param authorization
	 * @param basiAuthInBase64
	 * @return Response
	 * @Description Used to send HTTP_POST request 
	 */
	public static Response sendHTTPPOSTRequest(String uri, String request,
			String authorization, String basiAuthInBase64) {
		try{

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				log.info("Request is : "+ request+"\n");

				response = RestAssured.given().header(authorization	, basiAuthInBase64)
						.and().contentType("application/json").body(request).when().post(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		}catch(Exception e){
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}

	/**
	 * @param uri
	 * @param request
	 * @param authorization
	 * @param basiAuthInBase64
	 * @return Response
	 * @Description Used to send HTTP_PUT request 
	 */
	public static Response sendHTTPPUTRequest(String uri, String request,
			String authorization, String basiAuthInBase64) {
		try {

			if(uri!=null && request !=null){

			}else{
				log.error("URI and Request Can not be null");
			}

			log.info("Requested URI : " + uri);
			log.info("Request body is : " + request);

			response = RestAssured.given().header(authorization	, basiAuthInBase64)
					.and().contentType("application/json").body(request).when().put(uri);
			responseData = response.getBody().asString();
			System.out.println("\nResponse Body :  \n" + responseData + "\n");

		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}

	/**
	 * @param uri
	 * @param authorization
	 * @param basiAuthInBase64
	 * @return Response
	 * @Description Used to get HTTP_GET response 
	 */
	public static Response getHTTPGETResponse(String uri, String authorization,
			String basiAuthInBase64) {
		try {

			if(uri!=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().header(authorization	, basiAuthInBase64)
						.and().contentType("application/json").when().get(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}


	/**
	 * @param uri
	 * @param JSONObject 
	 * @return Response
	 * @Description Used to send get request with Header
	 */
	public static Response getHTTPGETResponse(String uri, JSONObject header) {
		try {

			if(uri!=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().headers(header)
						.and().contentType("application/json").when().get(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}



	public static String getBetweenStrings(String text,String textFrom,String textTo) {

		String result = "";

		// Cut the beginning of the text to not occasionally meet a      
		// 'textTo' value in it:
		result =
				text.substring(
						text.indexOf(textFrom) + textFrom.length(),
						text.length());

		// Cut the excessive ending of the text:
		result =
				result.substring(
						0,
						result.indexOf(textTo));

		return result;
	}

	public static Response getHTTPGETResponseUsingJSONFile(String uri, String headerName) {
		String JsonFilePath= System.getProperty("user.dir") + "\\src\\test\\resources\\data\\requestParams.json";
		String headerJSONString = RestUtil.getJSONStringFromJSONFile1(JsonFilePath);
		String text = headerJSONString;
		String textFrom=headerName + "\"" + ":" + "["; 
		System.out.println("Printing text From-->" +textFrom);
		String textTo="]";
		String headerAsString =getBetweenStrings(text, textFrom , textTo);
		System.out.println("Printing getBetweenString -- >> " +headerAsString);
		JSONParser parser = new JSONParser();
		JSONObject headerJSON = null;
		try {
			headerJSON = (JSONObject) parser.parse(headerAsString);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	

		System.out.println("Printing headerJSON  -->> " +headerJSON);
		try {

			if(uri!=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().headers(headerJSON)
						.and().contentType("application/json").when().get(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}



	/**
	 * @param uri
	 * @param authorization
	 * @param basiAuthInBase64
	 * @return Response
	 * @Description Used to delete resource By HTTP_Delete
	 */
	public static Response doHTTPDELETEResource(String uri,
			String authorization, String basiAuthInBase64) {
		try {

			if(uri!=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().header(authorization	, basiAuthInBase64)
						.and().contentType("application/json").when().delete(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}

	/**
	 * @param uri
	 * @param request
	 * @param headerKey1
	 * @param headerValue1
	 * @param headerKey2
	 * @param headerValue2
	 * @return String
	 * @Description Used to send HTTP_POST request
	 */
	public static String sendPOSTRequest(String uri, String request,
			String headerKey1, String headerValue1, String headerKey2, String headerValue2) {
		try {

			if(uri!=null && request !=null){
				log.info("Requested URI : " + uri);
				log.info("Request is : " + request + "\n");

				response = RestAssured.given().header(headerKey1, headerValue1)
						.header(headerKey2, headerValue2).and()
						.contentType("application/json").body(request).when().post(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n" + responseData + "\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @param headerKey1
	 * @param headerValue1
	 * @param headerKey2
	 * @param headerValue2
	 * @return String
	 * @Description Used to send HTTP_PUT request
	 */
	public static String sendPUTRequest(String uri, String request,
			String headerKey1, String headerValue1, String headerKey2, String headerValue2) {
		try {

			if(uri!=null && request !=null){
				log.info("Requested URI : " + uri);
				log.info("Request body is : " + request);

				response = RestAssured.given().header(headerKey1, headerValue1)
						.header(headerKey2, headerValue2).and()
						.contentType("application/json").body(request).when().put(uri);

				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n" + responseData + "\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @param headerKey1
	 * @param headerValue1
	 * @param headerKey2
	 * @param headerValue2
	 * @return String
	 * @Description Used to get HTTP_GET response
	 */
	public static String getGETResponse(String uri, String request,
			String headerKey1, String headerValue1, String headerKey2, String headerValue2) {
		try {

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().header(headerKey1, headerValue1)
						.header(headerKey2, headerValue2)
						.and().contentType("application/json").when().get(uri);

				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @param headerKey1
	 * @param headerValue1
	 * @param headerKey2
	 * @param headerValue2
	 * @return String
	 * @Description Used to delete resource By HTTP_Delete
	 */
	public static String doDELETEResource(String uri, String request,
			String headerKey1, String headerValue1, String headerKey2, String headerValue2) {
		try {

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().header(headerKey1, headerValue1)
						.header(headerKey2, headerValue2)
						.and().contentType("application/json").when().delete(uri);

				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @param headerKey1
	 * @param headerValue1
	 * @param headerKey2
	 * @param headerValue2
	 * @return String
	 * @Description Used to send HTTP_POST Array JSON request From File
	 */
	public static String sendHTTPPOSTRequestFromJSONFile(String uri, String request,
			String headerKey1, String headerValue1, String headerKey2, String headerValue2) {
		try {

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				JSONParser parser = new JSONParser();
				JSONObject object = (JSONObject) parser.parse(new FileReader(request));

				String jsonRequest = object.toJSONString();
				log.info("Request body is : "+ jsonRequest);

				response = RestAssured.given().header(headerKey1, headerValue1)
						.header(headerKey2, headerValue2).and()
						.contentType("application/json").body(jsonRequest).when().post(uri);

				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @param headerKey1
	 * @param headerValue1
	 * @param headerKey2
	 * @param headerValue2
	 * @return String
	 * @Description Used to send HTTP_PUT Array JSON request From File
	 */
	/*public static String sendHTTPPUTRequestFromJSONFile(String uri, String request,
			String headerKey1, String headerValue1, String  Key2, String headerValue2) {
		try {

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				JSONParser parser = new JSONParser();
				JSONObject object = (JSONObject) parser.parse(new FileReader(request));

				String jsonRequest = object.toJSONString();
				log.info("Request body is : "+ jsonRequest);

				response = RestAssured.given().header(headerKey1, headerValue1)
						.header(headerKey2, headerValue2).and()
						.contentType("application/json").body(jsonRequest).when().put(uri);

				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}*/

	/**
	 * @param uri
	 * @param request
	 * @param headerKey1
	 * @param headerValue1
	 * @param headerKey2
	 * @param headerValue2
	 * @return String
	 * @Description Used to send HTTP_POST Array JSON request From File
	 */
	public static String sendHTTPPOSTArrayRequestFromJSONFile(String uri, String request,
			String headerKey1, String headerValue1, String headerKey2, String headerValue2) {
		try {

			if(uri!=null && request !=null){

				log.info("Requested URI : "+uri);
				JSONParser parser = new JSONParser();
				JSONArray object = (JSONArray) parser.parse(new FileReader(request));

				String jsonRequest = object.toString();
				log.info("Request body is : "+ jsonRequest);

				response = RestAssured.given().header(headerKey1, headerValue1)
						.header(headerKey2, headerValue2).and()
						.contentType("application/json").body(jsonRequest).when().post(uri);

				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI and Request Can not be null");
			}


		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param uri
	 * @param request
	 * @param headerKey1
	 * @param headerValue1
	 * @param headerKey2
	 * @param headerValue2
	 * @return String
	 * @Description Used to send HTTP_PUT Array JSON request From File
	 */
	public static String sendHTTPPUTArrayRequestFromJSONFile(String uri, String request,
			String headerKey1, String headerValue1, String headerKey2, String headerValue2) {
		try {

			if(uri!=null && request !=null){
				log.info("Requested URI : " + uri);
				JSONParser parser = new JSONParser();
				JSONArray object = (JSONArray) parser.parse(new FileReader(request));

				String jsonRequest = object.toString();
				log.info("Request body is : " + jsonRequest);

				response = RestAssured.given().header(headerKey1, headerValue1)
						.header(headerKey2, headerValue2).and()
						.contentType("application/json").body(jsonRequest).when().put(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n" + responseData + "\n");
			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return responseData;
	}

	/**
	 * @param filePath
	 * @return String
	 * @Description used to get JSON String from JSON file
	 */
	public static JSONObject getJSONStringFromJSONFile(String filePath) {

		JSONParser parser = new JSONParser();
		JSONObject object = null;
		try {
			object = (JSONObject) parser.parse(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JSONObject jsonRequest = object;
		return jsonRequest;		
	}

	public static String getJSONStringFromJSONFile1(String filePath) {

		JSONParser parser = new JSONParser();
		JSONObject object = null;
		try {
			object = (JSONObject) parser.parse(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String jsonRequest = object.toJSONString();
		return jsonRequest;		
	}

	/**
	 * @param index
	 * @return String
	 * @Description getTestCaseName based on index
	 */
	protected String getTestCaseName(int index){

		StackTraceElement e[] = Thread.currentThread().getStackTrace();
		String methodName = e[index].getMethodName();

		return methodName;
	}

	/**
	 * @param folderName
	 * @return String
	 * @Description get request file path
	 */
	protected String getRequestFilePath(String folderName){

		String filePath = System.getProperty("baseDir")+folderName+"/"+getTestCaseName(3)+".json";
		return filePath;
	}



	/**
	 * @param uri
	 * @return String
	 * @Description Used to get HTTP_GET response.
	 */
	public static Response fetchGetResponse(String uri) {

		Response response = null;
		try {

			if(uri!=null){
				System.out.println("Requested URI : "+uri);
				response = RestAssured.given().contentType("application/json").when().get(uri);
				String responseData = response.getBody().asString();
				//				System.out.println("\nResponse Body :  \n"+responseData+"\n");
			}else{
				System.out.println("URI Can not be null");
			}
		} catch (Exception e) {
			System.out.println("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}


	public static String fetchResponseValue(String sUrl , String sJsonExpression) {

		try {
			Response r = RestUtil.fetchGetResponse(sUrl);
			if(r.asString()==null || r.toString().isEmpty())
			{
				return "";
			}

			System.out.println(r.asString());
			DocumentContext docCtx =JsonPath.parse(r.asString());		
			JsonPath jsonPath = JsonPath.compile(sJsonExpression);
			net.minidev.json.JSONArray val=docCtx.read(jsonPath);
			String n = docCtx.read(jsonPath).toString();


			return val.toJSONString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "";
		}
	}

	public static List<? extends Object> fetchResponseValue(String sUrl , String sJsonExpression, List <Header> listOfHeaders  ,String request) {
		try {
			Response r = RestUtil.getHTTPGETResponse(sUrl,listOfHeaders,request);
			if(r.asString()==null || r.toString().isEmpty()) {
				return null;
			}
			DocumentContext docCtx =JsonPath.parse(r.asString());
			JsonPath jsonPath = JsonPath.compile(sJsonExpression);
			net.minidev.json.JSONArray val=docCtx.read(jsonPath);
			return val;
		} catch (Exception e) {
			return null;
		}
	}

	public static String fetchPostResponseValue(String sUrl , String sJsonExpression, List <Header> listOfHeaders  ,String request) {

		try
		{
			Response r = RestUtil.getHTTPPOSTResponse(sUrl,listOfHeaders,request);
			if(r.asString()==null || r.toString().isEmpty())
			{
				return "";
			}

			System.out.println(r.asString());
			DocumentContext docCtx =JsonPath.parse(r.asString());
			System.out.println(docCtx);
			JsonPath jsonPath = JsonPath.compile(sJsonExpression);
			//net.minidev.json.JSONArray val=docCtx.read(jsonPath);
			String n = docCtx.read(jsonPath).toString();


			return n;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "";
		}
	}

	public static Response getHTTPGETResponse(String uri, List <Header> listOfHeaders  ,String request) {
		try{

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				log.info("Request is : "+ request+"\n");
				Headers header = new Headers (listOfHeaders);

				response = RestAssured.given().headers( header)
						.and().contentType("application/json").body(request).when().get(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		}catch(Exception e){
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}

	public static Response getHTTPPOSTResponse(String uri, List <Header> listOfHeaders  ,String request) {
		try{

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				log.info("Request is : "+ request+"\n");
				Headers header = new Headers (listOfHeaders);

				response = RestAssured.given().headers( header)
						.and().contentType("application/json").body(request).when().post(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		}catch(Exception e){
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}


	public static Response HTTPPOSTResponse(String uri, List <Header> listOfHeaders  ,String request) {
		try{

			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				log.info("Request is : "+ request+"\n");
				Headers header = new Headers (listOfHeaders);

				response = RestAssured.given().headers( header)
						.and().contentType("application/json").body(request).when().post(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		}catch(Exception e){
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}

	//#########################################SEO Specific API's ###############################################
	/**
	 * @param uri
	 * @param JSONObject 
	 * @return Response
	 * @Description Used to send get request with Header
	 */
	public static Response getHTTPGETResponseWithAuth(String uri, Map<String, ?> header, String uid, String sPwd) {
		try {

			if(uri!=null){
				log.info("Requested URI : "+uri);
				response = RestAssured.given().auth().basic(uid	, sPwd).headers(header)
						.and().contentType("application/json").when().get(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");
			}else{
				log.error("URI and Request Can not be null");
			}
		} catch (Exception e) {
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}


	public static List<Object> traverseJson(Response response, List<String> searchKey) {
		int blockNo = 0;
		//		String searchKey = "imageURL";
		System.out.println("In TraverseJson method ---" + response.path("$..partialData["+blockNo+"].."+searchKey+"").toString());
		return null;
	}

	public static Response postJSON_Request_withHeader(String uri, String request, Headers headers) throws Exception {
		try{
			if(uri!=null && request !=null){
				log.info("Requested URI : "+uri);
				log.info("Request is : "+ request+"\n");

				response = RestAssured.given().headers(headers)
						.and().contentType("application/json").body(request).when().post(uri);
				responseData = response.getBody().asString();
				log.info("\nResponse Body :  \n"+responseData+"\n");

			}else{
				log.error("URI and Request Can not be null");
			}
		}catch(Exception e){
			log.error("Not getting any Response from Server");
			Assert.fail("Not getting any Response from Server", e);
		}
		return response;
	}
	/**
	 * 
	 * @param result
	 * @param sJsonExpression
	 * @return
	 */
	public static String   fetchValueFromResponse( Response result , String sJsonExpression ) {
		if(result.asString()==null || result.toString().isEmpty())
		{
			return "";
		}
		
		System.out.println(result.asString());
		DocumentContext docCtx =JsonPath.parse(result.asString());
		System.out.println(docCtx);
		JsonPath jsonPath = JsonPath.compile(sJsonExpression);
		//net.minidev.json.JSONArray val=docCtx.read(jsonPath);
		String n = docCtx.read(jsonPath).toString();


		return n;
		
		
	}

	public static boolean isJSONValid(String jsonInString) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.readTree(jsonInString);
			return true;
		} catch(IOException e) {
			return false;
		}
	}

	public static List<? extends Object> parseJSON(String responseString, String sJsonExpression) {
		if(isJSONValid(responseString)) {
			DocumentContext docCtx =JsonPath.parse(responseString);
			JsonPath jsonPath = JsonPath.compile(sJsonExpression);
			net.minidev.json.JSONArray val=docCtx.read(jsonPath);
			return val;
		}
		return null;
	}
}
