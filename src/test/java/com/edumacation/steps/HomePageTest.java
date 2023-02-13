package com.edumacation.steps;

import com.edumacation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.edumacation.pages.HomePage.goTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest {
    HomePage homePage = new HomePage();

    @Given("user opens the {string} page")
    public void userOpensThePage(String webURL) {
        goTo(webURL);
    }

    @Then("the title {string} should exists")
    public void theTitleShouldExists(String checkString) {
        assertEquals(homePage.getHomePageHeading().getText(), checkString);
    }
}
