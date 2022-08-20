@CC-1049_Delete_one_Cell_Line
Feature: CC-1049:Delete one Cell Line

    this feature to check functionality of CRUD Cell Line
    
    Background: User has logged in on Cell Suite application and is on Cell Line menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Cell Line"
    Then user is navigated to "Cell Line" page
    And "my cell 5" items is "already" exist

    Scenario: Delete Cell Line
    When user select an item "my cell 5" by check the checkbox
    Then item "my cell 5" is checked
    And icon "delete" is enabled in page
    When user clicks on "delete" icon
    Then modal "Delete Cell Lines" confirmation is displayed
    When user clicks on "OK" button in modal
    Then notification "Success" and "Cell Lines has been deleted" is displayed
    And "my cell 5" items is "not" exist
    When user refresh the browser page
    And user is navigated to "Dashboard" page
    When user clicks on menu "Cell Line"
    Then user is navigated to "Cell Line" page
    And "my cell 5" items is "not" exist