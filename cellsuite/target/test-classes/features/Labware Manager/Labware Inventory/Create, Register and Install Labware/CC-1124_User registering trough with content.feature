@CC-1124
Feature: CC-1124:User registering trough with content

    this feature to check functionality of Labware Inventory
    Background: User has logged in on Cell Suite application and is on Labware Invenntory menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page
    # And data table show up

    Scenario: User registering trough with content
    When user clicks on "register" button
    Then user is navigated to "Register Inventory" page

    When user select "Trough 250" in dropdown "Labware"
    And user select "Reagent" in dropdown "Content Type"
    Then creat content menu is appear
    
     When user enter Exp Date ""
    When user select "25°C (Room Temperature)" in dropdown "Stored Temperature"
    When user clicks on "Create Content" button
    Then add content form is appear
    When "Through 250" user choose "RPMI 1640" and volume "250000"  
    And user clicks on "OK" button
    And user select "Generate by system" on barcode radio box
    And user enters "Some Notes" notes labware
    And user clicks on "Save" button
    Then user get notification "Success" and "Labware has been registered"
    And user get modal popup "Save Labware"
    And user clicks on "OK" button
    Then user is navigated to "Inventory" page
    And System "show" new item "Trough 250" 