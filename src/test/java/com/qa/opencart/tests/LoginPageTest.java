package com.qa.opencart.tests;

import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageTitleTest() {
        String title = loginPage.getLoginPageTitle();
        System.out.println("Login page title : " + title);
        Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
    }

    @Test
    public void loginPageURLTest() {
        String url = loginPage.getLoginPageUrl();
        System.out.println("Login page url : " + url);
        Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION)); //boolean value
    }

    @Test
    public void forgotPwdLinkTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @Test
    public void loginTest() {
        accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        Assert.assertTrue(accPage.isNewsletterLinkExist());
    }




}
