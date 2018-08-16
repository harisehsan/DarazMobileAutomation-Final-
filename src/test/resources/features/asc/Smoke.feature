@ASC
Feature: Smoke


  @test1
  Scenario: Seller cancel order successful
    Given I go to ASC login page
    When I login using seller "seller_271" account
    Then I should be logged in
    And I go to orders management page
    And I cancel the last item in orders page
    And I go to Cancelled orders Tab
    And I search for the current order
    Then I Should see order is displayed

  @test2
  Scenario: Seller rts order successful
    Given I go to ASC login page
    When I login using seller "seller_271" account
    Then I should be logged in
    And I go to orders management page
    And I RTS the last item in orders page
    And I go to RTS orders Tab
    And I search for the current order
    Then I Should see order is displayed




