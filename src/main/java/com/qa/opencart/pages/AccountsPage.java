package com.qa.opencart.pages;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private  WebDriver driver;
    private ElementUtil eleUtil;

    private By header = By.cssSelector("div#logo h1");
    private  By sections = By.cssSelector("div.list-group a");
//    private By newsletter = By.linkText("Newsletter");
    private By newsletter = By.xpath("(//*[text()='Newsletter'])[2]");
    private By search = By.name("search");
    private  By searchIcon = By.cssSelector("div#search button");

    public  AccountsPage(WebDriver driver){
        this.driver = driver;
        eleUtil = new ElementUtil(driver);

    }

    public  String getAccountsPageTitle(){
        return  eleUtil.doGetPageTitleIs(Constants.ACCOUNTS_PAGE_TITLE,Constants.DEFAULT_TIME_OUT);
    }

    public  String getAccountsPageUrl(){
        return  eleUtil.waitForUrlContains(Constants.ACCOUNTS_PAGE_URL_FRACTION,Constants.DEFAULT_TIME_OUT);
    }

    public String getAccPageHeader(){
        return eleUtil.doGetText(header);
    }

    public  boolean isNewsletterLinkExist(){
        return  eleUtil.doIsDisplayed(newsletter);
    }

    public  boolean newsletter(){
        if(isNewsletterLinkExist()){
            eleUtil.doClick(newsletter);
            return  true;
        }
        else
            return  false;

    }

    public List<String> getAccPageSections(){
        List<WebElement> sectionsList = eleUtil.waitForElementsVisible(sections,10);
        List<String> secValueList = new ArrayList<String>();
        for(WebElement e : sectionsList){
            String val = e.getText();
            secValueList.add(val);
        }
        return  secValueList;
    }

    public  boolean searchExist(){
        return  eleUtil.doIsDisplayed(search);
    }

    public  void  doSearch(String productName){
        if(searchExist()){
            eleUtil.doSendKeys(search,productName);
            eleUtil.doClick(searchIcon);
        }

    }





}
