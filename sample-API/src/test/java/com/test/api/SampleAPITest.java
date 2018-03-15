package com.test.api;

import static com.jayway.restassured.RestAssured.expect;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class SampleAPITest {
	
	Map<String,String> cookie = new HashMap<String,String>();
	//private static Logger logger = Logger.getAnonymousLogger();

	@Test
	public void getLivestreamurlofNode() {
		LogUtil.log("Nodes API - Test for get the live stream url of a node");
		LogUtil.log("*************************************************************************************");
		Response resp = expect().statusCode(200).log().all()
				.with().log().all()
				.pathParameters("id", "13")
				.when()
					.get("https://testexecution.platform.intuit.com/v1"
					+ "/nodes/{id}/livestream"
					+ "?intuit_apikey=prdakyresOf3EvFMkqSNMQKA6qYIyRmEO06Is4fS");
		
		LogUtil.log("Verifying response ");
		Assert.assertNotNull(resp.getBody().asString());
						

	}
	
	
	@Test
	public void SampleTest() {
		LogUtil.log("Sample REST API");
		Response resp = expect().statusCode(400)
		.log().all()
		.when()
		.get("https://www.googleapis.com/customsearch/v1");
		
		LogUtil.log("Response: " + resp.getBody().asString());

	}

	
}
