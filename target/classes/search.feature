Feature: Search
  As a user
  I want to test different types of search and price filters
  So that I can be sure that search and filters works correctly


  Scenario Outline: Check that price filter works correctly
    Given User opens '<homePage>' page
    When User clicks the All menu
    And User clicks on Computers sub-menu
    And User clicks on Computers & Tablets sub-menu
    And User input  minimum price '<minimum>' into min price window
    And User input maximum price '<maximum>' into max price window
    And User clicks Go button
    Then User checks that all items from filtered list has price between minimum '<minimum>' and maximum '<maximum>'

    Examples:
      | homePage                | minimum     | maximum     |
      | https://www.amazon.com/ | 1000        |  1200       |


  Scenario Outline: Check elements amount on search page
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    Then User checks that amount of products in search page are equal to expected amount'<amountOfProducts>'

    Examples:
      | homePage                | searchWord          | amountOfProducts |
      | https://www.amazon.com/ | iphone 12           | 16               |
      | https://www.amazon.com/ | samsung galaxy s21  | 16               |


  Scenario Outline: Check that URL contains search word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    Then User checks that current url contains search word '<searchWord>'

    Examples:
      | homePage                 | searchWord |
      | https://www.amazon.com/  | macbook    |





