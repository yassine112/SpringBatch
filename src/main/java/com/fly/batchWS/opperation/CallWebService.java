package com.fly.batchWS.opperation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.fly.batchWS.bean.WebService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author YCN
 *
 */
public class CallWebService {

	private static CallWebService instance;
	private Client client;
	private WebResource webResource;
	private ClientResponse response;

	private final String HTTP_GET = "Get";
	private final String HTTP_POST = "Post";
	private final String HTTP_PUT = "Put";
	private final String HTTP_DELETE = "Delete";

	public static CallWebService getInstance() {
		if (instance == null) {
			instance = new CallWebService();
		}
		return instance;
	}

	public CallWebService() {

	}

	/**
	 * Call the web service and get the result
	 * 
	 * @param Url
	 * @param Methode
	 * @return
	 */
	public void call(WebService webService) throws IOException {
		
		//Use Out to hold the response of web service 
		@SuppressWarnings("unused")
		Map<String, Object> out = null;

		try {

			client = Client.create();
			webResource = client.resource(webService.getUrlDirect());

			// Detect the method used in WebService
			if (webService.getMethode().equals(HTTP_GET)) {

				response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

			} else if (webService.getMethode().equals(HTTP_POST)) {

				response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, webService.getMsgEntree());

			} else if (webService.getMethode().equals(HTTP_PUT)) {

				response = webResource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, webService.getMsgEntree());

			} else if (webService.getMethode().equals(HTTP_DELETE)) {

				response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);

			}

			if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {

				System.err.println("ok : " + response.getStatus() + " : " + webService.getUrlDirect());

			} else {

				System.err.println("Failed : HTTP error code : " + response.getStatus() + " : " + webService.getUrlDirect());

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} 
	}

	/**
	 * <b>Convert String to JSON</b>
	 * 
	 * @param value
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private static Map<String, Object> getMapFromString(String value) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(value, LinkedHashMap.class);
	}
}
