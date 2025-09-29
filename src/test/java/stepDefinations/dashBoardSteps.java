package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;
import pageobjects.OrangeHrmLoginPage;
import pageobjects.dashBoardPage;

import java.io.IOException;

import static stepDefinations.BaseClass.driver;

public class dashBoardSteps extends BaseClass {
    public dashBoardSteps() throws IOException {
        dp=new dashBoardPage(driver);
    }

    @Then("Move to The DashBoard Side Menu")
    public void move_to_the_dash_board_side_menu() {
        logger.info("*** Moving to The DashBoard Page ***");
        dp.dashBoardSideMenu();

    }


    @Then("Finally Logout from The orangeHrm Application")
    public void Finally_Logout_from_The_orangeHrm_Application() {
        logger.info("*** Click The profile dropdown &Click The logout Button Button ***");
        dp.OrangeHrmlogout();

    }
}
