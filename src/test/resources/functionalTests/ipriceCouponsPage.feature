Feature: iprice homepage end to end tests

  Scenario: User is on the coupons page and looking for best deals
    Given User is on coupons page
    When He sees Top Stores
    Then Validate that all urls are active and link to proper stores
