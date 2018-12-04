@homepage
Feature: homepage Test

  @17974383
  Scenario: Guest users come to HomePage and visit to App Store page
    When  I go to HomePage
    And I click on Save More on App button
    Then I see pop up is display
    And I click on App Store icon
    Then I should land on App Store Page

  @17974379
  Scenario: Guest users come to HomePage and visit to Google Play page
    When  I go to HomePage
    And I click on Save More on App button
    Then I see pop up is display
    And I click on Google Play icon
    Then I should land on Google Play Page

  @17916153
  Scenario: Guest users come to HomePage and visit to App page
    When  I go to HomePage
    And I click on Save More on App button
    Then I see pop up is display
    And I click on App benefit text
    Then I should land on App Page

  @18009284
  Scenario: Guest users come to HomePage and visit to Sell On Lazada page
    When  I go to HomePage
    And I click on Sell On Lazada label
    Then I should land on Sell On Lazada Page

