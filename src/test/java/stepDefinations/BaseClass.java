package stepDefinations;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.*;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class BaseClass {
    //    public WebDriver driver;
    public static WebDriver driver; // Make it static to share across classes
    public static Logger logger;
    public static Properties configprop;


    public sideMenuPIMPage pim;

    public OrangeHrmLoginPage ohrmLP;
   public dashBoardPage dp;





    public static String randomString() {
        String generatedString1 = RandomStringUtils.randomAlphanumeric(8);
        return (generatedString1);
    }

    public static String MiddleName() {
        String generatedString1 = RandomStringUtils.randomAlphanumeric(1);
        return (generatedString1);
    }
    public static String lastName() {
        String generatedString1 = RandomStringUtils.randomAlphanumeric(4);
        return (generatedString1);
    }

    //random numbers

    public static String randomNumber() {
        return RandomStringUtils.randomNumeric(5); // Generates an 8-digit random number
    }



}








