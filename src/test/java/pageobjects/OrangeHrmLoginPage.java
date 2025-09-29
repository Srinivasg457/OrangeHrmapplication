package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import stepDefinations.BaseClass;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class OrangeHrmLoginPage extends BaseClass {


    public WebDriver ldriver;
    WaitHelper waithelper;
    public static Properties configprop;

    //constructor
    public OrangeHrmLoginPage(WebDriver rdriver) throws IOException {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
        waithelper = new WaitHelper(ldriver);

    }

    //xpath identification

    {


        try {
            configprop = new Properties();
            String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            FileInputStream configProfile = new FileInputStream(configPath);

            configprop.load(configProfile);


        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }




    By txt_orangeHrmUserName=By.xpath((configprop.getProperty("orangeHrmUserName")));

    By txt_orangehrmPassword=By.xpath(configprop.getProperty("orangehrmPassword"));
    By btn_Login=By.xpath(configprop.getProperty("btnLogin"));



    public void OrangeHrmUserName(String UserName) {

        try {
            WebElement userName = waithelper.WaitForElement1(txt_orangeHrmUserName, 30);
            userName.click();
            userName.clear();
            userName.sendKeys(UserName);
        }  catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    public void OrangeHrmpassword(String pwd) {
        try {
            WebElement Password = waithelper.WaitForElement1(txt_orangehrmPassword, 30);

            Password.click();
            Password.clear();
            Password.sendKeys(pwd);
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public void orangeHrmLoginButton( ) {

        try {
            WebElement loginButton = waithelper.WaitForElement1(btn_Login, 30);
            if(loginButton.isDisplayed() && loginButton.isEnabled()){

                JavascriptExecutor js = (JavascriptExecutor) driver;
               js.executeScript("arguments[0].click();", loginButton);
                Assert.assertTrue(true);
                System.out.println("Clicked Using the Java Script Executor");

            }
            else{
               Assert.fail("The Login Button Not Displayed and Not Present");
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }


    }

}
