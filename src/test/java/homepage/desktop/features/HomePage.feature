@homepage
Feature: homepage Test

  @P0Case
  Scenario: Guest users come to HomePage and visit to App Store page
    When  I go to HomePage
    And I click on Save More on App button
    Then I see pop up is display
    And I click on App Store icon
    Then I should land on App Store Page

  Scenario: Guest users come to HomePage and visit to Google Play page
    When  I go to HomePage
    And I click on Save More on App button
    Then I see pop up is display
    And I click on Google Play icon
    Then I should land on Google Play Page

  Scenario: Guest users come to HomePage and visit to App page
    When  I go to HomePage
    And I click on Save More on App button
    Then I see pop up is display
    And I click on App benefit text
    Then I should land on App Page
  @18009334
  Scenario: Guest users come to HomePage and visit to App page
     When  I go to HomePage
     And I click on Customer Care label
     Then I see Customer Care pop up is display
     And I click on Help Center label
     Then I should land on Help Center Page