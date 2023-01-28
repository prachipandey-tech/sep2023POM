package com.qa.opencart.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// driver initialize
public class DriverFactory {

    //declare driver
    public WebDriver driver;

    /*
    This method use to initialize the webdriver.
     */

    public WebDriver init_driver(Properties prop) {
        // Properties has getProperty - keys name define.
        String browserName=  prop.getProperty("browser").trim();  // trim() remove the spaces at the end from text.
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.chromedriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equals("safari")) {
            WebDriverManager.chromedriver().setup();
            driver = new SafariDriver();
        } else {
            System.out.println("please pass right browser : " + browserName);
        }
        driver.manage().window().fullscreen();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        return driver;
    }
        // prop method - is use initialize Properties
    // return Properties prop refrences.

        public Properties init_prop() throws IOException {
        // calling Properties class from java utils to call config file
            Properties prop = new Properties();
                        // initialize config file using FileStream class
                        FileInputStream ip = new FileInputStream("./src/test/resources/config");
                        // prop obj load all config details in key values pair.
            prop.load(ip);
            return prop;

    }
}
