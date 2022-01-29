package org.mycompany.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.minidev.json.parser.ParseException;
import org.mycompany.utils.CommonUtils;
import org.mycompany.utils.RestApiUtil;
import org.mycompany.utils.ScenarioContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

public class MainApiStepDefs {

    @Autowired
    RestApiUtil restApiUtil;

    @Autowired
    CommonUtils commonUtils;

    @Autowired
    ScenarioContext scenarioContext;

    @Autowired
    MySampleSteps mySampleSteps;



//    @Profile("apinew")
    @Given("user executes {string} request api {string} with params {string} headers {string} and payload {string}")
    public void userExecutesRequestApiWithParamsHeadersAndPayload(String httpReqType, String endpoint, String paramsList, String headers, String payload) throws IOException, ParseException {
        restApiUtil.executeMainApiRequest(httpReqType, endpoint, paramsList, headers, payload);
    }

    @When("response code is {string}")
    public void response_code_is(String ResponseCODE) {
        int respCode = Integer.parseInt(ResponseCODE);
        restApiUtil.verifyResponseCode(respCode);
        System.out.println("resp code mathed .....!!!");
        System.out.println("READING From scenario context: "+scenarioContext.getStatusCode());
        mySampleSteps.testingContext();
    }

    @Then("Verifies that {string} is present in the response")
    public void verifies_that_string_is_present_in_the_response(String strToCheck) {

        // Write code here that turns the phrase above into concrete actions
        System.out.println("Hurray");


    }

//    @Given("user executes {string} request api {string} with params {string} headers {string} and payload {string}")
//    public void userExecutesRequestApiWithParamsHeadersAndPayload(String arg0, String arg1, String arg2, String arg3, String arg4) {
//    }


}
