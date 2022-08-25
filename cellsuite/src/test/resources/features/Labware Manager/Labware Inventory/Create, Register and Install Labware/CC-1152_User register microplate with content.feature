@CC-1152_User_register_microplate_with_content
Feature: CC-1152:User register microplate with content 

    this feature to verify that user can registering microplate with content on it
    
    Background: User has logged in on Cell Suite application and is on Labware Invenntory page
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Cell Line"
    Then user is navigated to "Cell Line" page
    And "HeLa" items is "already" exist
    When user clicks on menu "Labware"
    And user clicks on sub-menu "Inventory"
    Then user is navigated to "Inventory" page
    
    Scenario: User register single empty 1 Well plate
    When user clicks on "Register" button
    Then user is navigated to "Register Inventory" page
    When user select "SBS One Well" in dropdown "Labware"
    Then dropdown "Labware" is filled by "SBS One Well"
    And user select "Cell" in dropdown "Content Type"
    Then dropdown "Content Type" is filled by "Cell"
    And "Create Content" menu is appear
    When user clicks on "Create Content" button
    Then dialog for defining "Add Content" is displayed
    When user choose content "HeLa" and fill volume "150"
    Then content selected as "Hela" and volume displayed as "150"  


    And user clicks on "OK" button
    And user clicks on "Save" button
    Then notification "Success" and "Labware has been registered" is displayed
    And modal "Save Labware" confirmation is displayed
    When user clicks button OK in modal Save Labware
    Then user is navigated to "Inventory" page
    And there is new item "SBS One Well" created in table with empty exp date

     
    
    