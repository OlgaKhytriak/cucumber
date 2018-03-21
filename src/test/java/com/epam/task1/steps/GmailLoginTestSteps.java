package com.epam.task1.steps;

import com.epam.task1.businessobjects.DraftsBO;
import com.epam.task1.businessobjects.GmailLogInBO;
import com.epam.task1.data.handlers.LattersDataCreator;
import com.epam.task1.data.model.Letter;
import com.epam.task1.data.model.User;
import com.epam.task1.driver.SafeThreadDriverCreator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;

public class GmailLoginTestSteps {
    private GmailLogInBO gmailLogInBO;
    private User user;

    @Given("^user navigates to gmail login page$")
    public void userNavigatesGmailLoginPage() {
        gmailLogInBO = new GmailLogInBO();
        gmailLogInBO.openLoginPage();
    }
/*
    @When("^user types login and password$")
    public void userTypesLoginAndPassword() {
        User user = new User("ForHometaskTest3@gmail.com", "12345aKids");
        System.out.println(user.toString());
        gmailLogInBO.login(user);
    }

    @When("^user types login \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userTypesLoginAndPassword(String login, String password) {
        User user = new User(login, password);
        System.out.println(user.toString());
        gmailLogInBO.login(user);
    }
    */
    @When("^user types login (\\S+) and password (\\S+)$")
    public void userTypesLoginAndPasswordScenario(String login, String password) {
        User user = new User(login, password);
        System.out.println(user.toString());
        gmailLogInBO.login(user);
    }

    @Then("^user should see gmail homepage$")
    public void userShouldSeeGmailHomepage() {
        assertTrue(gmailLogInBO.isUserLoggedIn());
    }

}