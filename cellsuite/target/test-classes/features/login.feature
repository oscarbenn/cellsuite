@loginFeature
Feature: login

    Check login functionality

    Scenario: login will success with valid credentials
        Given user is navigated to website "http://localhost:5050"
        Then user is on login page
        When user enters username as "admin" and password as "admin"
        And user clicks on signIn button
        Then user is navigated to home page