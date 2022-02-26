package com.headless;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessConcept {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions co = new ChromeOptions();
        //co.addArguments("--headless");
        co.addArguments("--incognito");
        //co.setHeadless(true);

        /**
         * execution fast
         * its blocking the browser launch
         *
         */

        //launch chrome
        WebDriver driver = new ChromeDriver(co);

        //enter the url
        driver.get("https://www.google.com/");
        //get the title of the page
        String title = driver.getTitle();
        System.out.println("title is : "+title);

        //verification point / checkpoint / act vs exp result:
        if(title.equalsIgnoreCase("Google")){
            System.out.println("correct title");
        }
        else{
            System.out.println("incorrect title");
        }
        //=Automation testing
        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());

        if(driver.getPageSource().contains("Copyright The Closure Library Authors")){
            System.out.println("is present....");
        }

        //close the browser
        driver.quit();
    }
}
