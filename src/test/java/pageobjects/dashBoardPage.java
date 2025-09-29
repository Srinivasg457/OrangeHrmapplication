package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class dashBoardPage {

    public WebDriver ldriver;
    WaitHelper waithelper;
    public static Properties configprop;

    //constructor
    public dashBoardPage(WebDriver rdriver) throws IOException {
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




    By DashBoardSideMenu=By.xpath((configprop.getProperty("DashBoardSideMenu")));

    By userDropDown=By.xpath(configprop.getProperty("userDropDown"));
    By orangeAppLogout=By.xpath(configprop.getProperty("orangeAppLogout"));



    public void dashBoardSideMenu() {

        try {
            WebElement userName = waithelper.WaitForElement1(DashBoardSideMenu, 30);
            userName.click();
        }  catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    public void OrangeHrmlogout() {

        try {
            WebElement userDrp = waithelper.WaitForElement1(userDropDown, 30);
            userDrp.click();

            WebElement appLogout = waithelper.WaitForElement1(orangeAppLogout, 30);
            appLogout.click();;
        }  catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


}
