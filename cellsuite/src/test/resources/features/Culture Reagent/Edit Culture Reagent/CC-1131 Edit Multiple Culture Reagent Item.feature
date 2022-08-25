@reagentculture
@CC-1131_Edit_Multiple_Culture_Reagent_Item
Feature: CC-1131: Edit Multiple Culture Reagent Item

    This test case is to make sure the user could edit multiple Culture Reagent Item

    Background: User is on Culture Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Culture Reagent"
    Then user is navigated to "Culture Reagent" page
    And "Reagent 8 Culture" items is "already" exist
    And "Reagent 9 Culture" items is "already" exist

    Scenario: Select and Edit multiple culture reagent item
    When user select an item "Reagent 8 Culture" by check the checkbox
    Then item "Reagent 8 Culture" is checked
    And icon "edit" is enabled in page
    When user select an item "Reagent 9 Culture" by check the checkbox
    Then item "Reagent 9 Culture" is checked
    When user clicks on "edit" icon
    Then user is navigated to "Edit Culture Reagent" page
    When user "change" "Reagent 8.0 Culture" in "name" textbox
    Then textbox "name" will fill by "Reagent 8.0 Culture"
    When user "change" "Create Reagent 8.0 Culture" in "notes" textbox
    Then textbox "notes" will fill by "Create Reagent 8.0 Culture"
    When user select reagent compotition "Trypsin" and type "100" in persentage
    Then composition reagent selected is "Trypsin" 
    And accepted total volume of reagent is "100"
    When user clicks on "Save" button
    Then modal "Save Confirm" confirmation is displayed
    When user clicks on "OK" button
    Then notification "Success" and "Culture Reagent has been updated" is displayed

    And user clicks on "next" icon
    When user "change" "Reagent 9.0 Culture" in "name" textbox
    Then textbox "name" will fill by "Reagent 9.0 Culture"
    And user "change" "Create Reagent 9.0 Culture" in "notes" textbox
    Then textbox "notes" will fill by "Create Reagent 9.0 Culture"
    When user select reagent compotition "Trypsin" and type "100" in persentage
    Then composition reagent selected is "Trypsin" 
    And accepted total volume of reagent is "100"
    When user clicks on "Save" button
    Then modal "Save Confirm" confirmation is displayed
    When user clicks on "OK" button
    Then notification "Success" and "Culture Reagent has been updated" is displayed

    When user clicks on "close" icon
    Then user is navigated to "Culture Reagent" page
    # And reagent is updated and saved with name "Reagent 3.0" and note "Reagent 3.0 with Antibiotic"
