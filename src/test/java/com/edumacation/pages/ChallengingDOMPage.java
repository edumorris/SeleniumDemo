package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.Driver.getDriver;

@Getter
public class ChallengingDOMPage {
    @FindBy(xpath = "//a[@class='button']")
    private WebElement firstButton;

    @FindBy(xpath = "//a[@class='button alert']")
    private WebElement secondButton;

    @FindBy(xpath = "//a[@class='button success']")
    private WebElement thirdButton;

    @FindBy(xpath = "//canvas")
    private WebElement answerCanvas;
    public ChallengingDOMPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getCanvasAnswer() {
        return answerCanvas.getText();
    }
}
