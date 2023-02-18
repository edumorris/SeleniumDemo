package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.Driver.getDriver;

@Getter
public class DigestAuthPage {
    @FindBy(xpath = "//h3")
    private WebElement digestAuthPageTitle;

    @FindBy(xpath = "//p")
    private WebElement digestAuthConfirmText;
    public DigestAuthPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getText(String whatText) {
        if (whatText.equals("pageTitle")) {
            return digestAuthPageTitle.getText().trim();
        } else if (whatText.equals("confirmText")) {
            return digestAuthConfirmText.getText().trim();
        }

        return null;
    }
}
