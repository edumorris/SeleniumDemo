package com.edumacation.pages;

import io.cucumber.java.en_old.Ac;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.edumacation.utility.Driver.getDriver;

@Getter
public class DragDropPage {
    @FindBy(id = "column-a")
    private WebElement elementA;

    @FindBy(id = "column-b")
    private WebElement elementB;

    @FindBy(xpath = "//*[@id='column-a']/header")
    private WebElement elementAHeader;

    @FindBy(xpath = "//*[@id='column-b']/header")
    private WebElement elementBHeader;
    public DragDropPage() {
        PageFactory.initElements(getDriver(), this);
    }

    Actions actions = new Actions(getDriver());
    public void dragDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).build().perform();
    }

    public void dragDrop() {
        actions.clickAndHold(elementA)
                .pause(Duration.ofSeconds(2))
                .moveToElement(elementB)
                .pause(Duration.ofSeconds(2))
                .release()
                .build()
                .perform();
        // ToDo, action class isn't working
    }

    public String columnHeader(String col) {
        String colText = "";
        if (col.equals("A")) {
            colText = elementAHeader.getText();
        } else if (col.equals("B")) {
            colText = elementBHeader.getText();
        }

        return colText;
    }
}
