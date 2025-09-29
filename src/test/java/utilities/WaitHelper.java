package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {

    public WebDriver driver;

    public WaitHelper(WebDriver driver) {

        this.driver = driver;
    }


// for the config.properties file reader wait
    public WebElement WaitForElement1(By locator, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        // Wait until the element is visible and return the WebElement
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
