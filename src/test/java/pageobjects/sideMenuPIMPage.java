package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinations.BaseClass;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class sideMenuPIMPage extends BaseClass {

    public WebDriver ldriver;
    WaitHelper waithelper;

    public static Properties configprop;

    //constructor
    public sideMenuPIMPage(WebDriver rdriver) throws IOException {
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
    //Locators
    By pimsideMenu = By.xpath(configprop.getProperty("sideMeniPIM"));
    By btnAddNewemp = By.xpath(configprop.getProperty("btnAddNew"));


    By txtFirstName = By.xpath(configprop.getProperty("txtFirstName"));
    By txtMiddlename = By.xpath(configprop.getProperty("txtMiddlename"));
    By txtLastName = By.xpath(configprop.getProperty("txtLastName"));
    By btnSaveEmployee=By.xpath(configprop.getProperty("btnSaveEmployee"));

    By txtEmployeeId=By.xpath(configprop.getProperty("txtEmpId"));

    By successMsg=By.xpath(configprop.getProperty("successMsg"));
    By tabAddEmpBtn=By.xpath(configprop.getProperty("tabAddEmpBtn"));
    By tabEmployeeList=By.xpath(configprop.getProperty("tabEmployeeList"));


    By footertext=By.xpath(configprop.getProperty("footertext"));


    By employee1=By.xpath(configprop.getProperty("employee1"));

    By tableload=By.xpath(configprop.getProperty("tableload"));

    //Actions Method

    public void pimSideMenu( ) {

        try {
            Actions actions = new Actions(driver);
            WebElement pimSideMenu = waithelper.WaitForElement1(pimsideMenu, 10);
            actions.moveToElement(pimSideMenu).click().build().perform();

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    public void addNewEmployeebtn( ) {

        try {
            WebElement AddNewemp = waithelper.WaitForElement1(btnAddNewemp, 10);
            AddNewemp.click();

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }



    public void fillEmployeename( ) {

        try {
            WebElement firstName = waithelper.WaitForElement1(txtFirstName, 10);
            firstName.click();
            firstName.clear();
            firstName.sendKeys(randomString());

            WebElement middlename = waithelper.WaitForElement1(txtMiddlename, 10);
            middlename.click();
            middlename.clear();
            middlename.sendKeys(MiddleName());

            WebElement lastName = waithelper.WaitForElement1(txtLastName, 10);
            lastName.click();
            lastName.clear();
            lastName.sendKeys(lastName());


            WebElement employeeId = waithelper.WaitForElement1(txtEmployeeId, 10);
            employeeId.click();
            employeeId.clear();
            employeeId.clear();
            employeeId.sendKeys(randomNumber());

            WebElement SaveEmpbtn = waithelper.WaitForElement1(btnSaveEmployee, 10);
            SaveEmpbtn.click();


            WebElement successMsgconfirmation = waithelper.WaitForElement1(successMsg, 10);
           String successmsg=successMsgconfirmation.getText();
           System.out.println(successmsg);


            WebElement switchTabAddEmpBtn = waithelper.WaitForElement1(tabAddEmpBtn, 10);
            switchTabAddEmpBtn.click();


        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }



    public void employeeList( ) {

        try {
            WebElement employeeListtab = waithelper.WaitForElement1(tabEmployeeList, 10);
            employeeListtab.click();

             WebElement tbload=waithelper.WaitForElement1(tableload,20);
             if(tbload.isDisplayed()){
                 System.out.println("The Emploayees Data Loaded Successfully");
             }
            WebElement pageBottom = waithelper.WaitForElement1(footertext, 10);

            JavascriptExecutor js = (JavascriptExecutor) ldriver;
//            // Smooth scroll to element
//            WebElement emp1 = waithelper.WaitForElement1(employee1, 10);
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'end'});", pageBottom);

              WebElement emp1 = waithelper.WaitForElement1(employee1, 10);
            // Print the header in tabular format
            System.out.format("%-10s %-25s %-15s%n", "ID", "First (& Middle) Name", "Last Name");
            // Print the raw data to debug
            String empDetails = emp1.getText();
            System.out.println("Employee Details Raw Text: " + empDetails);

// Clean up and split by multiple spaces
            String[] empInfo = empDetails.trim().split("\\s+");  // Split on one or more spaces

// Print the split result to see how the array looks
            System.out.println("Split Employee Info: " + Arrays.toString(empInfo));

            if (empInfo.length >= 3) {
                String empId = empInfo[0];
                String firstName = empInfo[1];  // Assuming only one first name
                String lastName = empInfo[empInfo.length - 1];  // Last name

                // If there are more than two names (middle name)
                if (empInfo.length > 3) {
                    firstName += " " + empInfo[2];  // Add middle name if exists
                }

                // Print in tabular format
                System.out.format("%-10s %-25s %-15s%n", empId, firstName, lastName);
            } else {
                System.out.println("Error: Employee details are not in the expected format.");
            }
            System.out.println("✓ Successfully scrolled to 'OrangeHRM OS 5.7' element directly");
//            System.out.format("%-10s %-20s %-15s%n", "ID", "  First (& Middle) Name  ", "  Last Name  ");
//               System.out.println(emp1.getText()+" Found employee 1 ");
//          //  js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
//            System.out.println("✓ Successfully scrolled to 'OrangeHRM OS 5.7' element directly");


        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

}
