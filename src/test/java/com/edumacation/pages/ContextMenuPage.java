package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.Driver.getDriver;

@Getter
public class ContextMenuPage {
    Actions actions = new Actions(getDriver());

    @FindBy(xpath = "//*[@id='hot-spot']")
    private WebElement contextMenuClickArea;
    public ContextMenuPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void rightClickContextMenuArea() {
        actions.contextClick(contextMenuClickArea).perform();
    }
}
