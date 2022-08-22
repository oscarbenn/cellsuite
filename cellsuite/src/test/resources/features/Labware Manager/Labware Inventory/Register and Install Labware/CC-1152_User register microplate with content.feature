@CC-1152
Feature: CC-1152:User register microplate with content 

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

    Scenario: User register microplate with content 
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "SBS One Well" in dropdown "Labware"
    And user select "Cell" in dropdown "Content Type"
    Then creat content menu is appear
    When user clicks on "Create Content" button
    Then add content form is appear
    When "SBS One Well" user choose "HeLa" and volume "150"  
    And user clicks on "OK" button
    And user select "Generate by system" on barcode radio box
    And user enters "Some Notes" notes labware
    And user clicks on "Save" button
    Then user get notification "Success" and "Labware has been registered"
    And user get modal popup "Save Labware"
    When user clicks on "OK" button
    Then user is navigated to "Inventory" page
    And System "show" new item "SBS 96 Wells" 