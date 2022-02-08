package com.qa.opencart.pages;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    //1.private By Locator
    private By emailId = By.id("input-email");
    private By password = By.id("input-password");
    private By loginBtn = By.xpath("//input[@value='Login']");
    private By forgotPwdLink = By.linkText("Forgotten Password");

    //2.page constructor:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    //3.public page actions/methods:
    public String getLoginPageTitle() {
//        return  driver.getTitle();
        return eleUtil.doGetPageTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
    }

    public String getLoginPageUrl() {
//        return  driver.getCurrentUrl();
        return eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
    }

    public boolean isForgotPwdLinkExist() {
//        return  driver.findElement(forgotPwdLink).isDisplayed();
        return eleUtil.doIsDisplayed(forgotPwdLink);
    }

    //Method responsibility to return next landing page class object
    public AccountsPage doLogin(String userName, String pwd) {
//        driver.findElement(emailId).sendKeys(userName);
//        driver.findElement(password).sendKeys(pwd);
//        driver.findElement(loginBtn).click();
        eleUtil.doSendKeys(emailId, userName);
        eleUtil.doSendKeys(password, pwd);
        eleUtil.doClick(loginBtn);
        return new AccountsPage(driver);
    }


}
