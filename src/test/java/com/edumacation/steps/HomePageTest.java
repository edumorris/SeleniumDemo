package com.edumacation.steps;

import com.edumacation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.edumacation.utility.ConfigReader.confRead;
import static com.edumacation.utility.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest {
    HomePage homePage = new HomePage();
    @Given("user opens the 'the-internet' page")
    public void userOpensTheInternetPage() {
        getDriver().get(confRead("the_internet_url"));
    }

    @Then("the title 'Welcome to the-internet' should exists")
    public void theTitleWelcomeToTheInternetShouldExists() {
        assertEquals(homePage.getHomePageHeading().getText(), "Welcome to the-internet");
    }
}
