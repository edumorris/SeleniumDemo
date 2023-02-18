package com.edumacation.steps;

import com.edumacation.pages.AuthenticationPage;
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

public class AuthenticationSteps {
    AuthenticationPage authPage = new AuthenticationPage();
    @When("the user enters the correct {string} and {string} for {string}")
    public void theUserEntersTheCorrectAnd(String uname, String pwd, String authType) {
        try {
            // Will not work using alert. Fix for HTTPClient
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

            // Switch to the alert
            Alert authAlert = wait.until(ExpectedConditions.alertIsPresent());

            // Enter the login data and accept
            authAlert.sendKeys(confRead(uname) + Keys.TAB + confRead(pwd));
            authAlert.accept();
        } catch (Exception ex) {
            authPage.authenticationUsingURL(uname, pwd, authType);
            waitFor(5);
        }
    }

    @Then("the user should see the authentication page with the header {string}")
    public void theUserShouldSeeTheAuthenticationPageWithTheHeader(String authPageTitle) {
        System.out.println(authPage.getPageTitleText());
        assertThat(authPage.getPageTitleText(), is(authPageTitle));
    }

    @And("the text {string}")
    public void theText(String authPageConfirmationText) {
        System.out.println(authPage.getAuthenticationText());
        assertThat(authPage.getAuthenticationText(), is(authPageConfirmationText));
    }
}
