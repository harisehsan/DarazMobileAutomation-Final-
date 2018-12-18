@homepage
Feature: homepage Test

  @17974383 @smoke
  Scenario: Guest users come to HomePage and visit to App Store page
    When  I go to HomePage
    And I click on Save More on App button
    Then I see pop up is display
    And I click on App Store icon
    Then I should land on App Store Page

  @17974379 @smoke
  Scenario: Guest users come to HomePage and visit to Google Play page
    When  I go to HomePage
    And I click on Save More on App button
    Then I see pop up is display
    And I click on Google Play icon
    Then I should land on Google Play Page

  @17916153 @smoke
  Scenario: Guest users come to HomePage and visit to App page
    When  I go to HomePage
    And I click on Save More on App button
    Then I see pop up is display
    And I click on App benefit text
    Then I should land on App Page

  @18009284 @smoke
  Scenario: Guest users come to HomePage and visit to Sell On Lazada page
    When  I go to HomePage
    And I click on Sell On Lazada label
    Then I should land on Sell On Lazada Page

  @18009334 @smoke
  Scenario: Guest users come to HomePage and visit Help Center page
    When  I go to HomePage
    And I click on Customer Care label
    Then I see Customer Care pop up is display
    And I click on Help Center label
    Then I should land on Help Center Page

  @18134723
  Scenario: Guest users come to HomePage and press loading button on Just For You
    When I go to HomePage
    And I scroll to Just For You part
    Then I should see Just For You module
    And I click on Load More button
    Then I should see new items loaded

  @18174993 @smoke
  Scenario: Guest users come to HomePage and select category level 2 to visit
    When I go to HomePage
    Then I should see category tree
    And I select random category level "2" on Categories Tree
    Then I should see category page that I selected

  @18263485 @smoke
  Scenario: Guest users come to HomePage and select category level 2 to visit
    When I go to HomePage
    Then I should see category tree
    And I select random category level "3" on Categories Tree
    Then I should see category page that I selected




