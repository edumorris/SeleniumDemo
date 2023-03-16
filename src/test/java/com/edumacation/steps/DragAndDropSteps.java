package com.edumacation.steps;

import com.edumacation.pages.DragDropPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

import static com.edumacation.utility.BrowserUtil.waitFor;
import static com.edumacation.utility.Driver.getDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DragAndDropSteps {
    DragDropPage ddPage = new DragDropPage();

    @When("the user drags element A to element B")
    public void theUserDragsElementAToElementB() {
        ddPage.dragDrop();

        waitFor(5);
    }
    @Then("the character inside element A should be {string}")
    public void theCharacterInsideElementAShouldBeB(String elA) {
        assertThat(ddPage.columnHeader(elA), is(elA));
    }

    @And("the character inside element B should be {string}")
    public void theCharacterInsideElementBShouldBeA(String elB) {
        assertThat(ddPage.columnHeader(elB), is(elB));
    }
}
