package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.Driver.getDriver;

@Getter
public class CheckboxesPage {

    @FindBy( xpath = "//*[@id='checkboxes']/input[1]")
    private WebElement firstCheckbox;

    @FindBy( xpath = "//*[@id='checkboxes']/input[2]")
    private WebElement secondCheckbox;

    public CheckboxesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isChecked(String checkboxNum) {
        if (checkboxNum.equals("first"))
            return firstCheckbox.isSelected();
        else if (checkboxNum.equals("second"))
            return secondCheckbox.isSelected();

        return false;
    }

    public void selectCheckbox(String checkboxNum) {
        if (checkboxNum.equals("first"))
            firstCheckbox.click();
        else if (checkboxNum.equals("second")) {
            secondCheckbox.click();
        }
    }
}
