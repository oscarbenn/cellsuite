@usermanagement
Feature: login feature

    Check login functionality

    Background: open browser and go to website
    Given user is navigated to website "http://localhost:5050/"
    Then user is on "Login" page
        
    @loginsuccess
    Scenario: login will success with valid credentials
        When user enters username as "admin"
        And user enters password as "admin"
        And user clicks on "SignIn" button
        Then user is navigated to "Dashboard" page

    @loginnotsuccess1
    Scenario: login will success with invalid credentials
        When user enters username as "admin"
        And user enters password as "adminadmin"
        And user clicks on "signIn" button
        Then error notification "Incorrect Username or password" is displayed

    @loginnotsuccess2
    Scenario: login will success with invalid credentials
        When user enters username as "admin"
        And user clicks on "signIn" button
        Then error validation "Please input your password!" is display

    @loginnotsuccess3
    Scenario: login will success with invalid credentials
        When user enters password as "admin"
        And user clicks on "signIn" button
        Then error validation "Please input your username!" is display
