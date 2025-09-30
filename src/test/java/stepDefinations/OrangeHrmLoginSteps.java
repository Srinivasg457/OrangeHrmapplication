package stepDefinations;

import io.cucumber.java.en.*;
import io.qameta.allure.*;
import pageobjects.OrangeHrmLoginPage;

import java.io.IOException;


public class OrangeHrmLoginSteps extends BaseClass {


    public OrangeHrmLoginSteps() throws IOException {
        ohrmLP=new OrangeHrmLoginPage(driver);
    }

    @Given("the user launches the Chrome browser")
    public void the_user_launches_the_chrome_browser() throws IOException {
        logger.info("*** launch The Browser ***");
        ohrmLP = new OrangeHrmLoginPage(driver);
    }
    @Given("the user navigates to the login page with the URL {string}")
    public void the_user_navigates_to_the_login_page_with_the_url(String url) {
        logger.info("*** launch The app URL***");
        driver.get(url);
    }
    @When("the user enters User Name {string}")
    public void the_user_enters_user_name(String username) {
        logger.info("*** Enter The User Name of The Orange HRM Portal***");
        ohrmLP.OrangeHrmUserName(username);
    }

    @When("the user Enters The Password {string}")
    public void the_user_enters_the_password(String pwd) {
        logger.info("*** Enter The password  of The Orange HRM Portal***");
        ohrmLP.OrangeHrmpassword(pwd);
    }

    @Then("the user Clicks The Login Button")
    public void the_user_clicks_the_login_button() {
        logger.info("*** Click The Login Button ***");
        ohrmLP.orangeHrmLoginButton();
    }

    @Then("Verify The Loggedin  Page Url")
    public void verify_the_loggedin_page_url() {
        logger.info("*** Logged In Page Validation ***");
        ohrmLP.loggedInvalidation();
    }




}
