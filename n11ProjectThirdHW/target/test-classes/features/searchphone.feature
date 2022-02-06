Feature: Search for phone
  Scenario: Search for phone, sort and list free shipments
    Given User opens the n11 main page
    When User search for telefon and selects the filter for second brand
    And User sorts the results according to comment count and selects free shipping option
    Then User sees the relevant results