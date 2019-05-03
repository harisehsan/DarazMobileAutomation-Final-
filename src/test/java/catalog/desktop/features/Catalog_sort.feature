@catalog_sort @smoke
Feature: Apply sort to the products in catalog

@20128963 @catalog_sort
Scenario: Sort the items by brand using the vertical filter
  Given I visit the catalog page
  And I apply price low to high filter
  Then I verify the sorted price catalog