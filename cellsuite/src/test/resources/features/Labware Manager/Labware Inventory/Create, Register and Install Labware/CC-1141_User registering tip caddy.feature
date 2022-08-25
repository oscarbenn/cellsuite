@CC-1141
Feature: CC-1141:User registering tip caddy

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

    Scenario: User registering tip caddy
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "Tip Caddy F1000" in dropdown "Labware"
    And user enters tip Amount "96" 
    And user select "Generate by system" on barcode radio box
    And user enters "Some Notes" notes labware
    And user clicks on "Save" button
    Then user get notification "Success" and "Labware has been registered"
    And user get modal popup "Save Labware"
    When user clicks on "OK" button
    Then user is navigated to "Inventory" page
    And System "show" new item "Tip Caddy F1000"