@PDP
Feature: PDP Test


  @Guest @normal
  Scenario: Guest can go to normal PDP
    When I go to "normal" pdp page
    Then I can see the PDP page loaded

  @Guest @digital
  Scenario: Guest can go to digital PDP
    When I go to "digital" pdp page
    Then I can see the PDP page loaded

  @Guest @multisource
  Scenario: Guest can go to multisource PDP
    When I go to "multisource" pdp page
    Then I can see the PDP page loaded

  @Guest @oos
  Scenario: Guest can go to oos PDP
    When I go to "oos" pdp page
    Then I can see the PDP page loaded

  @Guest @grouping
  Scenario: Guest can go to grouping PDP
    When I go to "grouping" pdp page
    Then I can see the PDP page loaded

  @Guest @service
  Scenario: Guest can go to service PDP
    When I go to "service" pdp page
    Then I can see the PDP page loaded

  @Guest @tbc
  Scenario: Guest can go to tbc PDP
    When I go to "tbc" pdp page
    Then I can see the PDP page loaded

  @Guest @voucher
  Scenario: Guest can go to voucher PDP
    When I go to "voucher" pdp page
    Then I can see the PDP page loaded

  @Guest @seller_promotion
  Scenario: Guest can go to seller promotion PDP
    When I go to "seller_promotion" pdp page
    Then I can see the PDP page loaded

  @Guest @shipped_from_overseas
  Scenario: Guest can go to shipped from overseas PDP
    When I go to "shipped_from_overseas" pdp page
    Then I can see the PDP page loaded

  @Guest @many_pictures
  Scenario: Guest can go to many pictures PDP
    When I go to "many_pictures" pdp page
    Then I can see the PDP page loaded

  @Guest @official_store
  Scenario: Guest can go to official store PDP
    When I go to "official_store" pdp page
    Then I can see the PDP page loaded

  @Guest @video
  Scenario: Guest can go to video PDP
    When I go to "video" pdp page
    Then I can see the PDP page loaded

  @Guest @fbl
  Scenario: Guest can go to fbl PDP
    When I go to "fbl" pdp page
    Then I can see the PDP page loaded