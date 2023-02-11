package com.edumacation.pages;

import lombok.Getter;
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
}
