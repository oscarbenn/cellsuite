@CC-1045_Create_new_Cell_Line_by_filling_not_required_fields_only
Feature: CC-1045:Create new Cell Line by filling not required fields only

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
    When user "type" on box "Cell Density/cm2" as "9"
    Then box "Cell Density/cm2" filled by "9"
    When user clicks on "save" button
    Then alert Required is displayed on bottom of box
    | Name | Media Selection | Media Replacement | Feeding Interval | Detachment Reagent | Detachment Reagent Volume | Detachment Reagent Incubation Time | Passage Ratio | Adhering Time | Estimated Doubling Time |
    And alert Required is displayed on bottom of "Passage After"
    And alert Required is displayed on bottom of "Imaging Interval"
