package com.edumacation.pages;

import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.edumacation.utility.Driver.getDriver;

@Getter
public class AddAndRemoveElementPage {

    @FindBy(xpath = "//button[(.)='Add Element']")
    private WebElement addElementBtn;

    @FindBy(xpath = "//button[@class='added-manually' and (.)='Delete']")
    private WebElement deleteBtn;

    public AddAndRemoveElementPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void clickBtn(String btn) {
        switch (btn) {
            case "Add Element":
                addElementBtn.click();
                break;
            case "Delete":
                deleteBtn.click();
                break;
        }
    }

    public boolean checkForDeleteBtn() {
        try {
            return deleteBtn.isDisplayed();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
