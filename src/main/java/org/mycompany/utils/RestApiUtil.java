package org.mycompany.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.parser.ParseException;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RestApiUtil {

@Autowired
ScenarioContext scenarioContext;

    Response response = null;
    CommonUtils commonUtils = new CommonUtils();

//    String httpReqType, String headers, String endpint, String paramsList, String payload
    public Response executeMainApiRequest(String httpRequestType, String endPoint, String headerKeyVal,  String params, String payloadBody) throws IOException, ParseException {
        System.out.println("\n\n~~~~~~~~***** inside genericApiRequest() method *****~~~~~~~~");

        RequestSpecification requestSpecification = RestAssured.given();

        System.out.println("BASE_URI = "+commonUtils.getProperty("BASE_URI"));
        System.out.println("END point: "+endPoint);
        endPoint = commonUtils.getProperty("BASE_URI") + endPoint;

        System.out.println("Full Endpoint = "+endPoint);
        commonUtils.paramsSplitting(params);

        if (!headerKeyVal.equals("")) {
            String[] header = headerKeyVal.split(":");
            requestSpecification.header(header[0], header[1]);
        }

        requestSpecification.contentType(ContentType.JSON);

        if (httpRequestType.equalsIgnoreCase("post")) {
            System.out.println("*** POST request ***");
            if (!payloadBody.equals("")) {
                System.out.println("File contents: "+ (commonUtils.getProperty(payloadBody)));
                    requestSpecification.body(commonUtils.loadFile(commonUtils.getProperty(payloadBody)));


                response = requestSpecification.post(endPoint);
                System.out.println("POST Response: "+response.body().asString());
//            context.setContext("POST_RESPONSE", response);
            }
        } else if (httpRequestType.equalsIgnoreCase("get")) {
            System.out.println("*** GET request ***");
            response = requestSpecification.get(endPoint);
//            context.setContext("GET_RESPONSE", response);
        }
        scenarioContext.setStatusCode(response.getStatusCode());
        scenarioContext.setContext("API_RESPONSE",response.body().asString());

        System.out.println("*******  API statusCode = " + response.getStatusCode());

        System.out.println("READING From scenario context: "+scenarioContext.getStatusCode());

        return response;


    }


    public void verifyResponseCode(int respCode) {
        Assert.assertEquals(respCode, response.getStatusCode());
        System.out.println("Successfull 200 Code has received");

    }

}
