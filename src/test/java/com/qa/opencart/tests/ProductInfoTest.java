package com.qa.opencart.tests;

import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductInfoTest extends BaseTest{

    @BeforeClass
    public  void productInfoSetup(){
        accPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test
    public void productHeaderTest(){
        resultsPage = accPage.doSearch("Macbook");
        productInfoPage = resultsPage.selectProduct("MacBook Pro");
        Assert.assertEquals(productInfoPage.getProductHeaderName(),"MacBook Pro");
    }

    @DataProvider
    public  Object[][] productData(){
        return  new Object[][]{
                {"Macbook","MacBook Pro",Constants.MACBOOK_IMAGES_COUNT},
                {"Macbook","MacBook Air",Constants.MACBOOK_IMAGES_COUNT},
                {"iMac","iMac",Constants.IMAC_IMAGES_COUNT}
        };
    }

    @Test(dataProvider = "productData")
    public void productImagesCountTest(String productName, String mainProductName, int imagesCount){
        resultsPage = accPage.doSearch(productName);
        productInfoPage = resultsPage.selectProduct(mainProductName);
        int totalImages = productInfoPage.getProductImageCount();
        System.out.println("total images for : "+ mainProductName +" : "+imagesCount);
        Assert.assertEquals(totalImages, imagesCount);
    }

    /**
     * main product name: MacBook Pro
     * Brand:Apple
     * Availability:Out Of Stock
     * ExTaxPrice:Ex Tax: $2,000.00
     * total images : :4
     * price:$2,000.00
     * name:MacBook Pro
     * Product Code:Product 18
     * Reward Points:800
     */
    @Test
    public  void productDataTest(){
        resultsPage = accPage.doSearch("Macbook");
        productInfoPage = resultsPage.selectProduct("MacBook Pro");
        Map<String, String> actProductInfoMap = productInfoPage.getProductInfo();
        actProductInfoMap.forEach((k,v)->System.out.println(k+":"+v));
        //softAssert.assertEquals(actProductInfoMap.get("Brand"),"Apple12");
        softAssert.assertEquals(actProductInfoMap.get("Brand"),"Apple");
        softAssert.assertEquals(actProductInfoMap.get("price"),"$2,000.00");
        softAssert.assertAll();

    }
}
