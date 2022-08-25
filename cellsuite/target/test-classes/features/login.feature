@usermanagement
Feature: login feature

    Check login functionality

    Background: user is navigated to login page
        Given user is on Login page

    @loginsuccess
    Scenario: login will success with valid credentials
        When user enters username as "admin"
        And user enters password as "admin"
        And user clicks on "SIGN IN" button 
        Then user is navigated to "Dashboard" page

    @loginnotsuccess
    Scenario: login will not success with invalid credentials
        When user enters username as "admin"
        And user enters password as "adminadmin"
        And user clicks on "SIGN IN" button
        Then error notification "Incorrect Username or password" is displayed in Login page

    @loginnotsuccess
    Scenario: login will not success with invalid credentials
        When user enters username as "admin"
        And user clicks on "SIGN IN" button
        Then error validation "Please input your password!" is displayed in Login page

    @loginnotsuccess
    Scenario: login will not success with invalid credentials
        When user enters password as "admin"
        And user clicks on "SIGN IN" button
        Then error validation "Please input your username!" is displayed in Login page