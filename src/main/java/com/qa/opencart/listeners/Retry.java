package com.qa.opencart.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private static int maxTry = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if(!(iTestResult.isSuccess())){ //check if the test not succeed

            if(count < maxTry){ //check if maxTry count is reached

                count++; //Increase the maxTry count by 1
                iTestResult.setStatus(iTestResult.FAILURE); //Mark test as failed
                return  true;

            }
            else {
                iTestResult.setStatus(iTestResult.FAILURE); // If maxCount reached, test marked as failed
            }
        }
        else {
            iTestResult.setStatus(iTestResult.SUCCESS);// If test passes, TestNG marks it as passed
        }
        return false;
    }
}