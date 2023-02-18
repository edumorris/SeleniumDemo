package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.ConfigReader.confRead;
import static com.edumacation.utility.Driver.getDriver;

@Getter
public class AuthenticationPage {
    @FindBy(xpath = "//h3")
    private WebElement authPageTitle;

    @FindBy(xpath = "//p")
    private WebElement authConfirmText;
    public AuthenticationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void authenticationUsingURL(String uname, String pwd, String authType) {
        // The string below might need to be changed if there are more authentication types additions
        String authURL = "https://" + confRead(uname) + ":" + confRead(pwd) + "@the-internet.herokuapp.com/" + (authType.equals("Basic Auth") ? "basic_auth" : "digest_auth");
        getDriver().get(authURL);
    }

    public String getPageTitleText() {
        return authPageTitle.getText().trim();
    }

    public String getAuthenticationText() {
        return authConfirmText.getText().trim();
    }
}
