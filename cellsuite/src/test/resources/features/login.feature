@usermanagement
Feature: login feature

    Check login functionality

    Background: user is navigated to login page
        Given user is navigated to website "http://localhost:5050/"
        Then user is on "Login" page

    @loginsuccess
    Scenario: login will success with valid credentials
        When user enters username as "admin"
        And user enters password as "admin"
        And user clicks on "SignIn" button
        Then user is navigated to "Dashboard" page

    @loginnotsuccess
    Scenario: login will not success with invalid credentials
        When user enters username as "admin"
        And user enters password as "adminadmin"
        And user clicks on "SignIn" button
        Then error notification "Incorrect Username or password" is displayed

    @loginnotsuccess
    Scenario: login will not success with invalid credentials
        When user enters username as "admin"
        And user clicks on "SignIn" button
        Then error validation "Please input your password!" is display

    @loginnotsuccess
    Scenario: login will not success with invalid credentials
        When user enters password as "admin"
        And user clicks on "SignIn" button
        Then error validation "Please input your username!" is display