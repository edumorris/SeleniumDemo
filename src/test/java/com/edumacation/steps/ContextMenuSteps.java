package com.edumacation.steps;

import com.edumacation.pages.ContextMenuPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.edumacation.utility.BrowserUtil.waitFor;
import static com.edumacation.utility.Driver.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ContextMenuSteps {
    ContextMenuPage contextPage = new ContextMenuPage();

    @When("the user right clicks the context menu box")
    public void theUserRightClicksTheContextMenuBox() {
        contextPage.rightClickContextMenuArea();
    }

    @Then("a JavaScript alert with the message {string} appears")
    public void aJavaScriptAlertWithTheMessageAppears(String jsAlertMessage) {
        waitFor(5);
        assertThat(getDriver().switchTo().alert().getText(), is(jsAlertMessage));
    }
}
