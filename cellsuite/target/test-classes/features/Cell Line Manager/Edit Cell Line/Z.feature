@Z
@cellline
Feature: delete items my cell 2,6,1.0 edit,7.0 edit,8.1 edit

    this feature to clean item
    
    Background: User has logged in on Cell Suite application and is on Cell Line menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Cell Line"
    Then user is navigated to "Cell Line" page

    Scenario: Delete Cell Line
    When user select an item "my cell 2" by check the checkbox
    Then item "my cell 2" is checked
    And icon "delete" is enabled in page
    When user select an item "my cell 6" by check the checkbox
    Then item "my cell 6" is checked
    When user select an item "my cell 1.0 edit" by check the checkbox
    Then item "my cell 1.0 edit" is checked
    When user select an item "my cell 7.0 edit" by check the checkbox
    Then item "my cell 7.0 edit" is checked
    When user select an item "my cell 8.1 edit" by check the checkbox
    Then item "my cell 8.1 edit" is checked
    When user clicks on "delete" icon
    Then modal "Delete Cell Lines" confirmation is displayed
    When user clicks on "OK" button
    Then notification "Success" and "Cell Lines has been deleted" is displayed