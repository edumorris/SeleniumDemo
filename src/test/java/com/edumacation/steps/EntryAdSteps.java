package com.edumacation.steps;

import com.edumacation.pages.EntryAdPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.edumacation.utility.BrowserUtil.waitFor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static com.edumacation.utility.Driver.getDriver;

public class EntryAdSteps {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    EntryAdPage entryAdPage = new EntryAdPage();

    @Then("the user should {string} the advertisement")
    public void theUserShouldTheAdvertisement(String state) {
        if(state.equals("see")) {
            waitFor(5);
            assertThat(entryAdPage.getModalPopup().isDisplayed(), is(true));
        } else {
            waitFor(5);
            assertThat(entryAdPage.getModalPopup().isDisplayed(), is(false));
            // ToDo inspect reload behaviour of the button & refresh button
        }
    }
    @When("the page reloads")
    public void thePageReloads() {

        WebElement modalCloseBtn = entryAdPage.getModalCloseBtn();
        WebElement entryAdReloadBtn = entryAdPage.getEntryAdReloadBtn();

        wait.until(ExpectedConditions.elementToBeClickable(modalCloseBtn));
        modalCloseBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(entryAdReloadBtn));
        entryAdReloadBtn.click();

        waitFor(3);
    }
}
