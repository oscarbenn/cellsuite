@reagentlibrary
Feature: Create reagent 3-7

    This test case is to make sure the user could create new Reagent item

    Background: User is on Reagent menu
    Given user has already logged in to application with this credentials
    |username|password|
    |admin|admin|
    And user is navigated to "Dashboard" page
    When user clicks on menu "Reagent"
    And user clicks on sub-menu "Library"
    Then user is navigated to "Reagent Library" page

    Scenario: create new reagent item
    When user clicks on "create" button
    Then user is navigated to "Create Reagent" page
    When user fill the form in Create Reagent page with this data
    |nama|type|note|
    |Reagent 3|Antibiotic|Create Reagent 3 with Antibiotic|
    Then all fields in Create Reagent page is filled with this data
    |nama|type|note|
    |Reagent 3|Antibiotic|Create Reagent 3 with Antibiotic|
    When user clicks on "save" button
    And notification "Success" and "Reagent has been created" is displayed
    
    When user clicks on "create" button
    Then user is navigated to "Create Reagent" page
    When user fill the form in Create Reagent page with this data
    |nama|type|note|
    |Reagent 4|Antibiotic|Create Reagent 4 with Antibiotic|
    Then all fields in Create Reagent page is filled with this data
    |nama|type|note|
    |Reagent 4|Antibiotic|Create Reagent 4 with Antibiotic|
    When user clicks on "save" button
    And notification "Success" and "Reagent has been created" is displayed

    When user clicks on "create" button
    Then user is navigated to "Create Reagent" page
    When user fill the form in Create Reagent page with this data
    |nama|type|note|
    |Reagent 5|Antibiotic|Create Reagent 5 with Antibiotic|
    Then all fields in Create Reagent page is filled with this data
    |nama|type|note|
    |Reagent 5|Antibiotic|Create Reagent 5 with Antibiotic|
    When user clicks on "save" button
    And notification "Success" and "Reagent has been created" is displayed

    When user clicks on "create" button
    Then user is navigated to "Create Reagent" page
    When user fill the form in Create Reagent page with this data
    |nama|type|note|
    |Reagent 6|Antibiotic|Create Reagent 6 with Antibiotic|
    Then all fields in Create Reagent page is filled with this data
    |nama|type|note|
    |Reagent 6|Antibiotic|Create Reagent 6 with Antibiotic|
    When user clicks on "save" button
    And notification "Success" and "Reagent has been created" is displayed

    When user clicks on "create" button
    Then user is navigated to "Create Reagent" page
    When user fill the form in Create Reagent page with this data
    |nama|type|note|
    |Reagent 7|Antibiotic|Create Reagent 7 with Antibiotic|
    Then all fields in Create Reagent page is filled with this data
    |nama|type|note|
    |Reagent 7|Antibiotic|Create Reagent 7 with Antibiotic|
    When user clicks on "save" button
    And notification "Success" and "Reagent has been created" is displayed