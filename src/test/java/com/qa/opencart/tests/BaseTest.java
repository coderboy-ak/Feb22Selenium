package com.qa.opencart.tests;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    DriverFactory df;
    LoginPage loginPage;
    AccountsPage accPage;
    Properties prop;

    @BeforeTest
    public  void setUp(){
        df = new DriverFactory();
        prop = df.init_prop();
//      df.init_driver("chrome");  //error
//      driver = df.init_driver("chrome");
        driver = df.init_driver(prop);

        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public  void tearDown(){
        driver.quit();
    }
}
