package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.ConfigReader.confRead;
import static com.edumacation.utility.Driver.getDriver;

@Getter
public class BasicAuthPage {
    @FindBy(xpath = "//h3")
    private WebElement basicAuthPageTitle;

    @FindBy(xpath = "//p")
    private WebElement basicAuthConfirmText;
    public BasicAuthPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public static void authenticateUsingURL(String uname, String pwd) {
        String authURL = "https://" + confRead(uname) + ":" + confRead(pwd) + "@the-internet.herokuapp.com/basic_auth";
        getDriver().get(authURL);
    }

    public String getPageTitleText() {
        return basicAuthPageTitle.getText();
    }

    public String getAuthenticationText() {
        return basicAuthConfirmText.getText();
    }
}
