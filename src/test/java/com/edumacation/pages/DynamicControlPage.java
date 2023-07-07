package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.Driver.getDriver;

@Getter
public class DynamicControlPage {
    @FindBy(xpath = "//*[@id='checkbox-example']/button")
    private WebElement addOrRemoveCheckbox;

    @FindBy(xpath = "//*[@id='input-example']/button")
    private WebElement enableOrDisableInput;

    @FindBy(id = "message")
    private WebElement confirmationMessage;
    /*
        Input:
            It's disabled!
            It's enabled!
        Checkbox:
            It's gone!
            It's back!
     */

    public DynamicControlPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean checkboxIsDisplayed() {
        return getDriver().findElement(By.id("checkbox")).isDisplayed();
    }

    public boolean inputIsEnabled() {
        return getDriver().findElement(By.xpath("//input[@type='text']")).isEnabled();
    }
}
