package com.edumacation.steps;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static com.edumacation.utility.BrowserUtil.waitFor;
import static com.edumacation.utility.Driver.getDriver;

public class ExternalDragAndDrop {
    static WebDriver driver = getDriver();

    @BeforeAll
    public static void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void dragAndDrop() {
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        WebElement picA = driver.findElement(By.xpath("//*[@id=\"gallery\"]/li[1]"));

        WebElement trash = driver.findElement(By.id("trash"));

        Actions action = new Actions(driver);

        action.dragAndDrop(picA, trash).perform();

//        action.clickAndHold(picA)
//                .pause(Duration.ofSeconds(2))
//                .moveToElement(trash)
//                .pause(Duration.ofSeconds(2))
//                .release()
//                .build()
//                .perform();

        waitFor(5);
    }
}
