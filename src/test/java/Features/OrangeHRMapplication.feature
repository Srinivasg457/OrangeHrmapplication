Feature: Material Management Customer Module

  # Background for common steps
  Background:
    Given the user launches the Chrome browser
    And the user navigates to the login page with the URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"




  Scenario: Automating orange HRM And Performing The Operations
    When the user enters User Name "Admin"
    And the user Enters The Password "admin123"
    Then the user Clicks The Login Button
     Then The User Click on The PIm Side Menu
     And Add The Employees to The List
    Then move to employee List and find The Added Employees
     And Move to The DashBoard Side Menu
     And Finally Logout from The orangeHrm Application

  Scenario:Login Functionality for OrangeHrm Portal
    When the user enters User Name "Admin"
    And the user Enters The Password "admin123"
    Then the user Clicks The Login Button
    Then Verify The Loggedin  Page Url



