package com.edumacation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.edumacation.utility.Driver.getDriver;

public class BrokenImagesPage {
    public BrokenImagesPage() {
        PageFactory.initElements(getDriver(), this);
    }
    public static List<WebElement> pageImages() {
        return getDriver().findElements(By.cssSelector("img"));
    }
}
