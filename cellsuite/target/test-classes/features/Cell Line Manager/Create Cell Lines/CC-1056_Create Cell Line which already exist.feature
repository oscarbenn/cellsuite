@CC-1056_Create_Cell_Line_which_already_exist
Feature: CC-1056:Create Cell Line which already exist

    this feature to check functionality of CRUD Cell Line
    
    Background: User has logged in on Cell Suite application and is on Cell Line menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Cell Line"
    Then user is navigated to "Cell Line" page
    And "my cell 1" items is "already" exist
    When user clicks on "create" button
    Then user is navigated to "Create Cell Lines" page

    Scenario: Create New Cell Line
    When user "type" "my cell 1" in "name" textbox
    Then textbox "name" will fill by "my cell 1"
    When user fill textbox "organism" as "Mouse"
    Then textbox "organism" filled by "Mouse"
    When user fill textbox "tissue" as "Embryo"
    Then textbox "tissue" filled by "Embryo"
    When user fill textbox "morphology" as "Fibroblast"
    Then textbox "morphology" filled by "Fibroblast"
    When user "type" "mimic human liver" in "disease" textbox
    Then textbox "disease" will fill by "mimic human liver"
    When user "type" "sample cell from mouse liver" in "notes" textbox
    Then textbox "notes" will fill by "sample cell from mouse liver"
    When user select "confluency" radio
    Then radio "confluency" is selected
    And checkbox "Imaging Interval" is disable
    When user type cell line confluency as "80"
    Then cell line confluency is filled by "80"

    When user clicks on "Media Selection" select box
    Then modal "Select Media Selection" confirmation is displayed
    When user choose item "DMEM FBS 10" in modal select
    Then "DMEM FBS 10" item is selected in the modal
    When user clicks on "OK" button in modal
    Then select box "Media Selection" filled by "DMEM FBS 10"
    
    When user select "100%" on Media Replacement persentage
    Then Media Replacement persentage filled by "100%"
    When user "type" on box "Feeding Interval" as "48"
    Then box "Feeding Interval" filled by "48"

    When user clicks on "Detachment Reagent" select box
    Then modal "Select Detachment Selection" confirmation is displayed
    When user choose item "Trypsin" in modal select
    Then "Trypsin" item is selected in the modal
    When user clicks on "OK" button in modal
    Then select box "Detachment Reagent" filled by "Trypsin"
    
    When user "type" on box "Detachment Reagent Volume" as "600"
    Then box "Detachment Reagent Volume" filled by "600"
    When user "type" on box "Detachment Reagent Incubation Time" as "15"
    Then box "Detachment Reagent Incubation Time" filled by "15"
    When user "type" on box "Passage Ratio" as "3"
    Then box "Passage Ratio" filled by "3"
    When user "type" on box "Adhering Time" as "6"
    Then box "Adhering Time" filled by "6"
    When user type on box Imaging Interval as "48"
    Then box Imaging Interval filled by "48"
    When user "type" on box "Estimated Doubling Time" as "48"
    Then box "Estimated Doubling Time" filled by "48"
    When user "type" on box "Cell Density/cm2" as "9"
    Then box "Cell Density/cm2" filled by "9"
    
    When user "type" on box Cell Dye Ratio as "1" to "1"
    Then box Cell Dye Ratio filled by "1" to "1"

    When user clicks on "save" button
    Then notification "One or more validation errors occurred." and "Name already exists. Use another Name." is displayed