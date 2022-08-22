@CC-1134
Feature: CC-1134:User registering empty trough

    this feature to check functionality of Labware Inventory
    Background: User has logged in on Cell Suite application and is on Labware Invenntory menu
    Given user is navigated to website "http://localhost:5050"
    Then user is navigated to "Login" page
    Then user is navigated to "Login" page
    When user enters "Username" as "admin"
    Then "admin" is typed on "Username" textbox
    When user enters "Password" as "admin"
    Then "admin" is typed on "Password" textbox
    And user clicks on "SIGN IN" button
    Then user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page
    And data table show up

    Scenario: User registering empty trough
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "Trough 250" in dropdown "Labware"
    And user select "Empty" in dropdown "Content Type"
    And user enters labware count "1"
    And user select "Generate by system" on barcode radio box
    And user enters "Some Notes" notes labware
    And user clicks on "Save" button
    And user get modal popup "Save Labware"
    Then user get notification "Success" and "Labware has been registered"
    When user clicks on "OK" button
    Then user is navigated to "Inventory" page
    And System "show" new item "Trough 250" 
    



