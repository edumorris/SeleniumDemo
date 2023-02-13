package com.edumacation.steps;

import com.edumacation.pages.AddAndRemoveElementPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.edumacation.pages.HomePage.clickLink;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddAndRemoveElementSteps {
    AddAndRemoveElementPage addRemovePage = new AddAndRemoveElementPage();
    @And("the user clicks the {string} link")
    public void userOpenThePage(String addAndRemoveElementLinkText) {
        clickLink(addAndRemoveElementLinkText);
    }

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String addElementBtnTxt) {
        addRemovePage.clickBtn(addElementBtnTxt);
    }

    @Then("a button with the class {string} and the text {string} should appear")
    public void aButtonWithTheClassAndTheTextShouldAppear(String btnClass, String btnText) {
        assertThat(addRemovePage.getDeleteBtn().getAttribute("class"), is(btnClass));
        assertThat(addRemovePage.getDeleteBtn().getText(), is(btnText));
    }

    @When("user clicks the {string} button")
    public void userClicksTheButton(String deleteBtnTxt) {
        addRemovePage.clickBtn(deleteBtnTxt);

    }

    @Then("the {string} button should no longer be visible")
    public void theButtonShouldNoLongerBeVisible(String deleteBtn) {
        assertThat(addRemovePage.checkForDeleteBtn(), is(false));
    }
}
