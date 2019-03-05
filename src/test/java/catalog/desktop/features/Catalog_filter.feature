  @catalog @filter @desktop @fire_test @19116911
Feature: Apply filters to the products in catalog

  @catalog_filter @filter_brand_vertical @27226916
  Scenario: Filter the items by brand using the vertical filter
    Given I visit the catalog page
    When  I apply the vertical "brand" filter
    Then  "brand" Filter should be applied

  @catalog_filter @filter_vertical @filter_size_vertical @27226085
  Scenario: Filter the items by size using the vertical filter
    Given I visit the catalog page
    And   I search "Random" in header
    When  I apply the vertical "size" filter
    Then  "size" Filter should be applied

  @catalog_filter @filter_vertical @filter_color_vertical @27226087
  Scenario: Filter the items by color using the vertical filter
    Given I visit the catalog page
    And   I search "random" in header
    When  I apply the vertical "Color Family" filter
    Then  "Color Family" Filter should be applied

  @catalog_filter @filter_vertical @filter_price_vertical @27226088
  Scenario: Filter the items by Price Range vertical filter
    Given I visit the catalog page
    And   I search "random" in header
    When  I apply the vertical "Price Range" filter
    Then  "Price Range" Filter should be applied

# Combine Filters
  @catalog_filter @combine_two_filters @27226089
  Scenario: Filter the items by combining Brand and Price filters
    Given I visit the catalog page
    When  I search "Random" in header
    And  I apply the vertical "Price Range" filter
    And   I apply the vertical "brand" filter
    Then Filter should be applied

# Remove Filters
  @catalog_filter @reset_all_finters @27226091 @shahbaz1
  Scenario: Apply two filters and rest filters
    Given I visit the catalog page
    When  I search "Random" in header
    And  I apply the vertical "Price Range" filter
    And   I apply the vertical "brand" filter
    And   I remove "All" filters
    Then  "All" Filters should be removed

# Remove one filters
  @catalog_filter @reset_ONE_filter @27226093
  Scenario: Remove one filter
    Given I visit the catalog page
    When  I search "random" in header
    And   I apply the vertical "Price Range" filter
    And   I apply the vertical "brand" filter
    And   I remove "One" filters
    Then  "One" Filters should be removed

