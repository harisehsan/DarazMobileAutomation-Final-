@homepage
Feature: homepage Test

  @P0Case 
  Scenario: Guest users come to HomePage and visit to App page
    When  I go to HomePage
    And I click on Save More on App button
    Then I see pop up is display
    And I click on App benefit text
    Then I should land on App Page