package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.Driver.getDriver;

@Getter
public class DynamicControlPage {
    @FindBy(xpath = "//*[@id='checkbox-example']/button")
    private WebElement addOrRemoveCheckbox;

    @FindBy(id = "message")
    private WebElement checkboxMessage;


    public DynamicControlPage() {
        PageFactory.initElements(getDriver(), this);
    }
}
