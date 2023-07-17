package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.Driver.getDriver;

@Getter
public class EntryAdPage {
    @FindBy(id = "modal")
    private WebElement modalPopup;

    @FindBy(xpath = "//div[@class='modal-footer']/p")
    private WebElement modalCloseBtn;

    @FindBy(id = "restart-ad")
    private WebElement entryAdReloadBtn;

    public EntryAdPage() {
        PageFactory.initElements(getDriver(), this);
    }
}
