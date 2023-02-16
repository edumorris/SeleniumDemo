package com.edumacation.steps;

import com.edumacation.pages.BrokenImagesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static com.edumacation.pages.HomePage.clickLink;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BrokenImagesSteps {
    ArrayList<WebElement> brokenLinks;
    @When("the user accesses the {string} link")
    public void theUserClicksOnAnImageLink(String brokenImagePage) {
        clickLink(brokenImagePage);
    }

    @Then("the user should be able to see all images")
    public void theUserShouldBeAbleToAccessTheImage() throws IOException {
        for (WebElement pageImage : BrokenImagesPage.pageImages()) {
            // Get image status codes
            URL imageURL = new URL(pageImage.getAttribute("src"));
            HttpURLConnection connection = (HttpURLConnection) imageURL.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int statusCode = connection.getResponseCode();

            System.out.println(statusCode);

            assertThat(statusCode, is(200));
        }
    }
}
