@CC-1051_Cancel_delete_Cell_Line
Feature: CC-1051:Cancel delete Cell Line

    this feature to check functionality of CRUD Cell Line
    
    Background: User has logged in on Cell Suite application and is on Cell Line menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Cell Line"
    Then user is navigated to "Cell Line" page
    And "my cell 3" items is "already" exist

    Scenario: Delete Cell Line
    When user select an item "my cell 3" by check the checkbox
    Then item "my cell 3" is checked
    And icon "delete" is enabled in page
    When user clicks on "delete" icon
    Then modal "Delete Cell Lines" confirmation is displayed
    When user clicks on "Cancel" button in modal
    Then "my cell 3" items is "still" exist
    Then item "my cell 3" is checked
    And icon "delete" is enabled in page