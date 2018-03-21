package com.epam.task1.steps;

import com.epam.task1.businessobjects.DraftsBO;
import com.epam.task1.businessobjects.GmailLogInBO;
import com.epam.task1.data.handlers.LattersDataCreator;
import com.epam.task1.data.model.Letter;
import com.epam.task1.data.model.User;
import com.epam.task1.data.model.Users;
import com.epam.task1.driver.SafeThreadDriverCreator;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;

public class GmailDraftTestSteps {
    private DraftsBO draftsBO;
    private Letter letter;


    @When("^user creates draft$")
    public void userCreatesDraft() {
        draftsBO = new DraftsBO();
        letter = new Letter();
        letter = new LattersDataCreator().getLetters().getLetter(0);
        draftsBO.createDraft(letter);
    }

    @Then("^draft should be on the drafts page$")
    public void draftShouldBeOnDraftsPage() {
        draftsBO.openDrafts();
        assertTrue(draftsBO.isMessageInDrafts(letter));
    }

    @When("^user sends draft$")
    public void userSendsDraft() {
        draftsBO.sendMessageFromDrafts(letter);
    }

    @Then("^the draft should be on the sent mails page$")
    public void draftShouldBeOnSentMailsPage() {
        draftsBO.openSentMails();
        assertTrue(draftsBO.isMessageInSent(letter));

    }

    @After
    public void tearDown() {
        //SafeThreadDriverCreator.getInstance().removeDriver();
    }
}