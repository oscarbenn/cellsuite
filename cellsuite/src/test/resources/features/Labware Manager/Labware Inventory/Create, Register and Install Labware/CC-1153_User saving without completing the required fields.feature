@CC-1153_User_saving_without_completing_the_required_fields
Feature: CC-1153:User saving without completing the required fields

    this feature to verified that system gives error text on the fields that need to be filled by user when user saving without filling it

    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page

    Scenario: User saving without completing the required fields
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    And user clicks on "Save" button
    Then error required text on "Labware" is displayed
    And error required text on "Content Type" is displayed
