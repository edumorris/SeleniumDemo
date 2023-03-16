package com.edumacation.steps;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.edumacation.utility.BrowserUtil.waitFor;
import static com.edumacation.utility.Driver.getDriver;

public class Votes {
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
    public void automaticVote() {

        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            driver.get("https://d3hoops.com/notables/2023/03/nabc-all-star-voting");
        } catch (Exception ex) {
            driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
        }



        WebElement voteFor = driver.findElement(By.xpath("//input[@type='radio'][ @id='Ryan Algier, Rochester']"));

        voteFor.click();

        driver.findElement(By.xpath("//input[@value='Submit Vote']")).click();
    }
}
