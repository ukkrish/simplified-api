package org.mycompany.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import org.mycompany.config.Config;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Config.class)
@CucumberContextConfiguration
public class CucumberSpringConfiguration {
}
