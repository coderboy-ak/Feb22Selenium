package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {

    /**
     * static in nature > no need to create object
     * never going to change like URL / Page title
     */
    public  static  final  String LOGIN_PAGE_TITLE = "Account Login";
    public  static  final  String LOGIN_PAGE_URL_FRACTION = "account/login";
    public  static  final  int DEFAULT_TIME_OUT = 5;
    public  static  final  String ACCOUNTS_PAGE_TITLE = "My Account";
    public  static  final  String ACCOUNTS_PAGE_URL_FRACTION = "route=account/account";
    public  static  final  String ACCOUNTS_PAGE_HEADER = "Your Store";
    //shortcut of creating ArrayList or can use .add elements
    public  static  final List<String> ACCOUNTS_PAGE_SECTIONS_LIST =
            Arrays.asList("My Account","Edit Account","Password","Address Book","Wish List"
                   ,"Order History","Downloads","Recurring payments","Reward Points","Returns"
                    ,"Transactions","Newsletter","Logout");



}
