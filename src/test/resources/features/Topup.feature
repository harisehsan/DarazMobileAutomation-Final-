@Topup
Feature: Topup Test

  @Guest
  Scenario: Guest go to topup page and enter number
    When I go to topup page
    And I Enter number "88888888"
    And I Select product "$5 Green Card Top-up"
    And I Push top-up now


  @CheckOperatorSelecting
    Scenario: Guest go to topup page and select operator
      When I go to topup page
      And I Select operator


  @CheckListOfNumber
  Scenario: Logged go to topup page and select number from list
    When I go to topup page
    And I Log in from TopUp page, account: "tangsi.hwt@taobao.com", password: "hello1234"
    And I check after login
    And I select phone number from list


  @Logged
  Scenario: Logged go to topup page and select number from list
    When I go to topup page
    And I Enter number "88888888"
    And I Select product "$5 Green Card Top-up"
    And I Push top-up now


  @ProductTab
  Scenario: Logged go to topup page, select data tab and select product
    When I go to topup page
    And I Enter number "88888888"
    And I Select product tab "Data"
    And I Select product "Starhub Data Plan- 10MB (7 Days)"


  @Chekout
  Scenario: select product and go to checkout
    When I go to topup page
    And I Enter number "83573125"
    And I Select product "$5 hi! Top-up Card"
    And I Push top-up now
    And I select credit card payment method
    And I open new card
    And I enter card data number:"4111111111111111", name:"sdfsdf", date:"1222", cvv:"123"
    And I don't save card
    And I confirm pay
    And I Select product "Starhub Data Plan- 10MB (7 Days)"
