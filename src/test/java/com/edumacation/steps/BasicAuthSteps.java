package com.edumacation.steps;

import com.edumacation.pages.BasicAuthPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.edumacation.utility.BrowserUtil.waitFor;
import static com.edumacation.utility.ConfigReader.confRead;
import static com.edumacation.utility.Driver.getDriver;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasicAuthSteps {
    BasicAuthPage authPage = new BasicAuthPage();
    @When("the user enters the correct {string} and {string}")
    public void theUserEntersTheCorrectAnd(String uname, String pwd) {
        try {
            // Will not work using alert. Fix for HTTPClient
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

            // Switch to the alert
            Alert authAlert = wait.until(ExpectedConditions.alertIsPresent());

            // Enter the login data and accept
            authAlert.sendKeys(confRead(uname) + Keys.TAB + confRead(pwd));
            authAlert.accept();
        } catch (Exception ex) {
            BasicAuthPage.authenticateUsingURL(uname, pwd);
        }
    }

    @Then("the user should see the authentication page with the header {string}")
    public void theUserShouldSeeTheAuthenticationPageWithTheHeader(String authPageTitle) {
        assertThat(authPage.getPageTitleText(), is(authPageTitle));
    }

    @And("the text {string}")
    public void theText(String authPageConfirmationText) {
        assertThat(authPage.getAuthenticationText(), is(authPageConfirmationText));
    }
}
