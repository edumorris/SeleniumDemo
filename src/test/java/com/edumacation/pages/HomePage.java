package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.ConfigReader.confRead;
import static com.edumacation.utility.Driver.getDriver;

@Getter
public class HomePage {
    @FindBy(xpath = "//*[@class='heading']")
    private WebElement homePageHeading;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public static void goTo() {
        getDriver().get(confRead("the_internet_url"));
    }

    public static void goTo(String url) {
        getDriver().get(confRead(url));
    }

    /**
     * Method searches for a link text on the homepage using the string passed and clicks the found link
     * @param linkText
     */
    public static void clickLink(String linkText) {
        getDriver().findElement(By.linkText(linkText)).click();
    }
}
