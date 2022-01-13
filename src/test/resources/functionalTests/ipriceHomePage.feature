Feature: iprice homepage end to end tests

  Scenario: User is on the home page and looking for best deals
    Given User is on homepage
    When He sees all best deals
    And He sees Top Trending Products
    Then Count the list of the stores in the Find the Best Deals Online
    And Count the list of items in Top Trending Products
    And Validate that each item in Top Trending Products contains "data-vars-cgt"
