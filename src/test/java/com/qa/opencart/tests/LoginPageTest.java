package com.qa.opencart.tests;

import com.qa.opencart.listeners.AnnotationTransformer;
import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.utils.Constants;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("EPIC - 100 : Design Login page for Open Cart Application....")

@Story("US - 101 : Login Page Features")

@Listeners({AnnotationTransformer.class, TestAllureListener.class})
public class LoginPageTest extends BaseTest {

    //Allure Report
    @Description("TC_01: login Page Title Test")
    @Severity(SeverityLevel.MINOR)
    //@Test(enabled = false)   //this test will not execute
    @Test
    public void loginPageTitleTest() {
        String title = loginPage.getLoginPageTitle();
        System.out.println("Login page title : " + title);
        Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
    }

    @Description("login page url test")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void loginPageURLTest() {
        String url = loginPage.getLoginPageUrl();
        System.out.println("Login page url : " + url);
        Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION)); //boolean value
    }

    @Description("this is testing forgot pwd link on login page")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void forgotPwdLinkTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
        //Assert.assertTrue(false);
    }

    @Description("positive test case for login with correct credentials...")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "login test with correct username and password")
    public void loginTest() {
        accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        Assert.assertTrue(accPage.isNewsletterLinkExist());
    }

}
