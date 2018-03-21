package com.epam.task1;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/GmailDraftTest.feature",
        //tags = "@smokeTest",
        glue = {"com.epam.task1.steps"}, format = {"pretty",
        "html:target/cucumber-html-report"})
public class Runner {
}

