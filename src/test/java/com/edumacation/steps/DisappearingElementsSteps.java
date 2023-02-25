package com.edumacation.steps;

import com.edumacation.pages.DisappearingElementsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.edumacation.utility.BrowserUtil.waitFor;
import static com.edumacation.utility.Driver.getDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DisappearingElementsSteps {
    DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage();

    @When("the user tries to access {string} link")
    public void theLinkShouldBePresentAndClickable(String linkName) {
        /*
            The logic in this code is hard coded and doesn't use POM
            The logic will run until the link is found which might not be efficient and will make the test run longer.
            Another exit criteria can be added in an if statement withing the while block
         */

        List<WebElement> galleryLinks = getDriver().findElements(By.xpath("//a[.='Gallery']"));

        while (galleryLinks.size() == 0) {
            getDriver().navigate().refresh();
            galleryLinks = getDriver().findElements(By.xpath("//a[.='Gallery']"));
            waitFor(5);
        }

        galleryLinks.get(0).click();
    }

    @Then("the url should be {string}")
    public void theUrlShouldBe(String expectedUrl) {
        assertThat(disappearingElementsPage.getUrl(), is(expectedUrl));
    }
}
