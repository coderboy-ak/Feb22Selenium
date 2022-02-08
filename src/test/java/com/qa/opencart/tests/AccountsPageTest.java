package com.qa.opencart.tests;

import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AccountsPageTest extends BaseTest {

    @BeforeClass
    public  void accPageSetup(){
        accPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test
    public  void accPageTitleTest(){
        String actTitle = accPage.getAccountsPageTitle();
        System.out.println("Acc page title : "+actTitle);
        Assert.assertEquals(actTitle, Constants.ACCOUNTS_PAGE_TITLE);
    }

    @Test
    public  void  accPageUrlTest(){
        String actUrl = accPage.getAccountsPageUrl();
        System.out.println("Acc page url : "+actUrl);
        Assert.assertTrue(actUrl.contains(Constants.ACCOUNTS_PAGE_URL_FRACTION));
    }

    @Test
    public  void accPageHeaderTest(){
        String header = accPage.getAccPageHeader();
        System.out.println("acc page header : "+header);
        Assert.assertEquals(header,Constants.ACCOUNTS_PAGE_HEADER);
    }

    @Test
    public  void newsletterLinkTest(){
        Assert.assertTrue(accPage.isNewsletterLinkExist());
    }

    @Test
    public  void searchExistTest(){
        Assert.assertTrue(accPage.searchExist());
    }

    @Test
    public  void accPageSectionsTest(){
        List<String> accSectionsList = accPage.getAccPageSections();
        System.out.println("actual sec list : "+accSectionsList);
        Assert.assertEquals(accSectionsList,Constants.ACCOUNTS_PAGE_SECTIONS_LIST);
    }




}
