@CC-1116_Create_new_Cell_Line_with_Passage_After_Time_Interval_and_Imaging_Interval
Feature: CC-1116:Create new Cell Line with Passage After Time Interval and Imaging Interval

    this feature to check functionality of CRUD Cell Line
    
    Background: User has logged in on Cell Suite application and is on Cell Line menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Cell Line"
    Then user is navigated to "Cell Line" page
    When user clicks on "create" button
    Then user is navigated to "Create Cell Lines" page

    Scenario: Create New Cell Line
    When user "type" "my cell 4" in "name" textbox
    Then textbox "name" will fill by "my cell 4"
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

    When user select "Time Interval" radio
    Then radio "Time Interval" is selected
    And checkbox "Imaging Interval" is enable
    When user type cell line time interval as "24"
    Then cell line time interval is filled by "24"

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
    
    When user clicks to check on "Imaging Interval" checkbox
    When user type on box Imaging Interval as "12"
    Then box Imaging Interval filled by "12"
    
    When user "type" on box "Estimated Doubling Time" as "48"
    Then box "Estimated Doubling Time" filled by "48"
    When user "type" on box "Cell Density/cm2" as "9"
    Then box "Cell Density/cm2" filled by "9"
    
    When user "type" on box Cell Dye Ratio as "1" to "1"
    Then box Cell Dye Ratio filled by "1" to "1"

    When user clicks on "save" button
    Then notification "Success" and "Cell Lines has been created" is displayed
    And user is navigated to "Cell Line" page
    When user clicks detail button of item "my cell 4"
    And user validating data new cell line
    | Name | Organism | Tissue | Morphology | Disease | Notes | Passage After | Media Selection | Media Replacement | Detachment Reagent | Detachment Reagent Volume | Detachment Reagent Incubation Time | Passage Ratio | Adhering Time | Using Imaging | Estimated Doubling Time | Cell Density/cm2 | Cell Dilution Ratio | Dye Dilution Ratio |
    | my cell 4 | Mouse | Embryo | Fibroblast | mimic human liver | sample cell from mouse liver | 24 hour(s) | DMEM FBS 10 | 100% | Trypsin | 600.0 µL | 15 minute(s) | 1 : 3 | 6 hour(s) | Yes | 48 hour(s) | 90000 x104 | 1 | 1 |
