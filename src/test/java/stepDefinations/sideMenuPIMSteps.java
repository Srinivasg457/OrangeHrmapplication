package stepDefinations;

import io.cucumber.java.en.*;
import pageobjects.sideMenuPIMPage;

import java.io.IOException;

public class sideMenuPIMSteps extends BaseClass {


    public sideMenuPIMSteps( ) throws IOException {
        pim=new sideMenuPIMPage(driver);
    }



    @Then("The User Click on The PIm Side Menu")
    public void the_user_click_on_the_p_im_side_menu() {
        logger.info("*** click the PIM side menu ***");
        pim.pimSideMenu();
    }

    @Then("Add The Employees to The List")
    public void add_the_employees_to_the_list() {
        logger.info("*** click Add New Button ***");
       pim.addNewEmployeebtn( );

        logger.info("*** Add 4 Employee details ***");
//        pim.fillEmployeename();
        for (int i = 0; i < 4; i++) {
            System.out.println("Creating employee " + (i + 1) + " of 4");
            pim.fillEmployeename();
        }
    }

    @Then("move to employee List and find The Added Employees")
    public void move_to_employee_list_and_find_the_added_employees() {
        logger.info("*** Find The 4 Employees ***");
       pim.employeeList();


    }



}
