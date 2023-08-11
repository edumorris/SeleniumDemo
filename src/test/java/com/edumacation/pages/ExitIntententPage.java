package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.Driver.getDriver;

// page_url = http://the-internet.herokuapp.com/exit_intent

@Getter
public class ExitIntententPage {
    @FindBy(xpath = "//div[@class='modal']")
    private WebElement modalWindow;

    @FindBy(css = "div[class='modal-footer'] p")
    private WebElement modalClose;

    public ExitIntententPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void closeModal() {

        modalClose.click();

    }

    public boolean isModalDisplayed() {

        return modalWindow.isDisplayed();

    }
}