@SelectOperatorBlockManual
Feature: Manual selection operator, when auto-detect switch off

  Scenario: check open operator block
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.co.th/mobilerecharge"
    And type to input with name "Phone input" text: "0982521223" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    Then check that element "Select operator block" is on "topup mobile" page

  Scenario: check that operator block opens at second time and closed
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.co.th/mobilerecharge"
    And type to input with name "Phone input" text: "0982521223" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    Then check that element "Select operator block" is on "topup mobile" page
    And select operator "my by cat"
    Then check that operator "https://th-live-02.slatic.net/original/d356490b92501ce0e2722c9dad967aaa.jpg" selected correct
    And click element "Operator button" on "topup mobile" page
    Then check that element "Select operator block" is on "topup mobile" page
    And click element "Grey area" on "topup mobile" page
    Then check that element "Operator button" is not on "topup mobile" page

  Scenario: check change operator
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.co.th/mobilerecharge"
    And type to input with name "Phone input" text: "0982521223" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    And select operator "my by cat"
    And click element "Operator button" on "topup mobile" page
    And select operator "dtac online"
    Then check that operator "https://th-live-02.slatic.net/original/f3ddaaf500c51e878a91c27735a2ff0f.jpg" selected correct

  Scenario: check change number
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.co.th/mobilerecharge"
    And type to input with name "Phone input" text: "0982521223" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    And select operator "my by cat"
    And type to input with name "Phone input" text: "0982524444" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    And select operator "dtac online"
    Then check that operator "https://th-live-02.slatic.net/original/f3ddaaf500c51e878a91c27735a2ff0f.jpg" selected correct


