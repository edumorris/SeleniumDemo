package com.edumacation.steps;

import com.edumacation.pages.DropDownPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DropDownSteps {
    DropDownPage dropDownPage = new DropDownPage();

    @When("the user selects {string}")
    public void theUserSelectsOption(String drpDwnSlct) {
        dropDownPage.selectDropDown("visibleText", drpDwnSlct);
    }

    @Then("the value of the drop down should be {string}")
    public void theValueOfTheDropDownShouldBeOption(String drpDwnSlct) {
        assertThat(dropDownPage.dropDownVal(), is(drpDwnSlct));
    }
}
