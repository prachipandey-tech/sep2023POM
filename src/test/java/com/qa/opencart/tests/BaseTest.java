package com.qa.opencart.tests;

import com.qa.opencart.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;

     @BeforeTest
    public void setup() throws IOException {
        // call obj of DriverFactory so that we can call its methods where chrome launch ..
    DriverFactory df = new DriverFactory();
    Properties prop = new Properties();
    driver = df.init_driver(prop);
    prop = df.init_prop();
    }

    @AfterTest
    public void tearDown(){
   driver.quit();
    }

}
