package com.edumacation.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.http.ConnectionFailedException;

public class WebDriverFactory {
    /*
        This utility method will produce a webdriver method depending on the browser name passed e.g.
        WebDriverFactory("chrome") >> gives chrome driver
     */

    public static WebDriver getDriver(String browser_name) {
        WebDriver driver;

        switch (browser_name.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

//                try {
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                } catch (ConnectionFailedException ex) {
//                    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//                    ChromeOptions options = new ChromeOptions();
//
//                    options.addArguments("--remote-allow-origins=*");
//
//                    driver = new ChromeDriver(options);
//                }

                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = (WebDriver) new OperaDriverManager();
                break;
            default:
                driver = null;
                System.err.println("Unknown browser type " + browser_name);
        }

        return driver;
    }
}
