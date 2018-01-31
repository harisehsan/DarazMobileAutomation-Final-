@Topup
Feature: Topup Test

  @Guest
  Scenario: Guest go to topup page and enter number
    When I go to topup page
    And I Enter number
    And I Select product "dewei_test_topup_vi"
    And I Push top-up now


  @CheckOperatorSelecting
    Scenario: Guest go to topup page and select operator
      When I go to topup page
      And I Select operator


  @CheckListOfNumber
  Scenario: Logged go to topup page and select number from list
    When I go to topup page
    And I Log in from TopUp page
    And I check after login
    And I select phone number from list


  @Logged
  Scenario: Logged go to topup page and select number from list
    When I go to topup page
    And I Enter number
    And I Select operator
    And I Select product "dewei_test_topup_vi"
    And I Push top-up now
