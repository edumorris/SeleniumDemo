package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.Driver.getDriver;

@Getter
public class DisappearingElementsPage {
    @FindBy(xpath = "//a[.='Home']")
    private WebElement homeLink;

    @FindBy(xpath = "//a[.='About']")
    private WebElement aboutLink;

    @FindBy(xpath = "//a[.='Contact Us']")
    private WebElement contactUsLink;

    @FindBy(xpath = "//a[.='Porfolio']")
    private WebElement portfolioLink;

    //The gallery link appears and disappears. Page reload and try catch method needed to avoid errors
    @FindBy(xpath = "//a[.='Gallery']")
    private WebElement galleryLink;

    public DisappearingElementsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * This method clicks the available links given the param name passed
     * @param linkName
     */
    public void clickLink(String linkName) {
        switch (linkName) {
            case "home":
                homeLink.click();
                break;
            case "about":
                aboutLink.click();
                break;
            case "contact":
                contactUsLink.click();
                break;
            case "portfolio":
                portfolioLink.click();
                break;
            case "gallery":
                galleryLink.click();
                break;
        }
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public String getUrl() {
        return getDriver().getCurrentUrl();
    }
}
