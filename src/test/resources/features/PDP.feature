@PDP
Feature: PDP Test


  @Guest @random
  Scenario: Guest can go to random PDP
    When I go to pdp page
    Then I can see the PDP page loaded

  @Guest @digital
  Scenario: Guest can go to random PDP
    When I go to "digital" pdp page
    Then I can see the PDP page loaded

  @Guest @multisource
  Scenario: Guest can go to random PDP
    When I go to "multisource" pdp page
    Then I can see the PDP page loaded

  @Guest @oos
  Scenario: Guest can go to random PDP
    When I go to "oos" pdp page
    Then I can see the PDP page loaded

  @Guest @grouping
  Scenario: Guest can go to random PDP
    When I go to "grouping" pdp page
    Then I can see the PDP page loaded

  @Guest @service
  Scenario: Guest can go to random PDP
    When I go to "service" pdp page
    Then I can see the PDP page loaded

  @Guest @tbc
  Scenario: Guest can go to random PDP
    When I go to "tbc" pdp page
    Then I can see the PDP page loaded

  @Guest @voucher
  Scenario: Guest can go to random PDP
    When I go to "voucher" pdp page
    Then I can see the PDP page loaded

  @Guest @seller_promotion
  Scenario: Guest can go to random PDP
    When I go to "seller promotion" pdp page
    Then I can see the PDP page loaded

  @Guest @shipped_from_overseas
  Scenario: Guest can go to random PDP
    When I go to "shipped from overseas" pdp page
    Then I can see the PDP page loaded

  @Guest @many_pictures
  Scenario: Guest can go to random PDP
    When I go to "many pictures" pdp page
    Then I can see the PDP page loaded