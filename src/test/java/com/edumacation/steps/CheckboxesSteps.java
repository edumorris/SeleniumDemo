package com.edumacation.steps;

import com.edumacation.pages.CheckboxesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.edumacation.utility.BrowserUtil.waitFor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckboxesSteps {
    CheckboxesPage checkboxPage = new CheckboxesPage();

    @Then("the {string} checkbox should not be checked")
    public void theCheckboxShouldNotBeChecked(String checkbox) {
        assertThat(checkboxPage.isChecked(checkbox), is(false));
    }

    @And("the {string} checkbox should be checked")
    public void theCheckboxShouldBeChecked(String checkbox) {
        assertThat(checkboxPage.isChecked(checkbox), is(true));
    }

    @When("the user clicks the {string} checkbox")
    public void theUserSelectsTheCheck(String checkbox) {
        checkboxPage.selectCheckbox(checkbox);
    }
}
