package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.edumacation.utility.Driver.getDriver;

@Getter
public class DropDownPage {
    @FindBy(id = "dropdown")
    private WebElement dropDown;

    public DropDownPage() {
        PageFactory.initElements(getDriver(), this);
    }

    private final Select drpDownList = new Select(getDriver().findElement(By.id("dropdown")));

    /**
     * Method selects the drop-down given the parameters passed
     * @param selectorType, the type of selection method. Should be visibleText, value or index
     * @param selector: the value of the selectorType passed
     */
    public void selectDropDown(String selectorType, String selector) {
        switch (selectorType) {
            case "visibleText":
                drpDownList.selectByVisibleText(selector);
                break;
            case "value":
                drpDownList.selectByValue(selector);
                break;
            case "index":
                int ind = Integer.parseInt(selector);
                drpDownList.selectByIndex(ind);
                break;
            default:

        }
    }

    /**
     * Method gets the value of the drop-down
     * @return value of the drop-down
     */
    public String dropDownVal() {
        return drpDownList.getFirstSelectedOption().getText();
    }
}
