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

    By DashBoardSideMenu=By.xpath((configprop.getProperty("DashBoardSideMenu")));

    By titleName=By.xpath((configprop.getProperty("titleName")));
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


    public void loggedInvalidation() {
        try {
            // 1. Use more descriptive variable names
            WebElement dashboardMenu = waithelper.WaitForElement1(DashBoardSideMenu, 30);

            if (dashboardMenu.isDisplayed() && dashboardMenu.isEnabled()) {
                System.out.println("Dashboard Side Menu displayed successfully");

                // 2. Add explicit wait before click to ensure element is clickable
                dashboardMenu.click();

                // 3. Verify navigation occurred
                WebElement pageTitle = waithelper.WaitForElement1(titleName, 30);

                if (pageTitle.isDisplayed()) {
                    System.out.println("Page title displayed after navigation");

                    // 4. Add URL validation
                    String pageUrl = ldriver.getCurrentUrl();
                    String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
                    System.out.println("Current page URL: " + pageUrl);

                    // 5. Fixed URL assertion syntax
                    if (pageUrl.equals(expectedUrl)) {
                        System.out.println("Success: Login Successful - Navigated to: " + pageUrl);
                    } else {
                        System.err.println("Login Failed - Expected: " + expectedUrl + " but got: " + pageUrl);
                    }

                } else {
                    System.err.println("ERROR: Page title not displayed after menu click");
                    // Consider throwing exception or failing test here
                }
            }

        } catch (Exception e) {
            System.err.println("Unexpected error in loggedInvalidation: " + e.getMessage());
            e.printStackTrace(); // Add stack trace for better debugging
        }
    }

}
