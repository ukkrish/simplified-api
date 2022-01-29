package org.mycompany.steps;

import org.mycompany.utils.ScenarioContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySampleSteps {
    @Autowired
    ScenarioContext scenarioContext;

    public void testingContext() {
        System.out.println("Status code from SCENARO CONTEXT: "+scenarioContext.getStatusCode());
        System.out.println("FULL Response from SCENARO CONTEXT: "+scenarioContext.getContext("API_RESPONSE"));



    }
}
