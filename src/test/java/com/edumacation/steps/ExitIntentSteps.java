package com.edumacation.steps;

import com.edumacation.pages.ExitIntententPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.swing.*;

import java.time.Duration;
import java.util.Collections;

import static com.edumacation.utility.BrowserUtil.waitFor;
import static com.edumacation.utility.Driver.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ExitIntentSteps {
    WebDriver driver = getDriver();

    ExitIntententPage exitIntentPage = new ExitIntententPage();

    @When("the user moves the mouse out of viewport")
    public void theUserMovesTheMouseOutOfViewport() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "var event = new MouseEvent('mouseleave', {" +
                        "view: window, bubbles: true, cancelable: true}); " +
                        "document.body.dispatchEvent(event);"
        );

    }

    @Then("the modal popup is displayed")
    public void theUserShouldHaveAModalPopupDisplayed() {
        waitFor(5);

        assertThat(exitIntentPage.getModalWindow().isDisplayed(), is(true));
    }

    @And("the modal popup is closed")
    public void theModalPopupIsClosed() {

        waitFor(2);

        exitIntentPage.closeModal();

        waitFor(2);

    }

    @Then("the modal popup should not be displayed")
    public void theModalPopupShouldNotBeDisplayed() {

        assertThat(exitIntentPage.getModalWindow().isDisplayed(), is(false));

    }
}
