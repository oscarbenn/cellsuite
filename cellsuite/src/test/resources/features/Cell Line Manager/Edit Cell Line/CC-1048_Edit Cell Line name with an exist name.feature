@cellline
@CC-1048_Edit_Cell_Line_name_with_an_exist_name
Feature: CC-1048:Edit Cell Line name with an exist name

    Feature Description

    Background: User has logged in on Cell Suite application and is on Cell Line menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Cell Line"
    Then user is navigated to "Cell Line" page
    And "my cell 6" items is "already" exist

    Scenario: Edit
    When user select an item "my cell 6" by check the checkbox
    Then item "my cell 6" is checked
    And icon "edit" is enabled in page
    When user clicks on "edit" icon
    Then user is navigated to "Edit Cell Lines" page
    When user "change" "my cell 1.0 edit" in "name" textbox
    And user clicks on "Save" button
    Then modal "Save Confirm" confirmation is displayed
    When user clicks on "OK" button
    Then notification "One or more validation errors occurred." and "Name already exists. Use another Name." is displayed