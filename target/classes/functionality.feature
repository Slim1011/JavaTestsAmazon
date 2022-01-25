Feature: Functionality
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly


  Scenario Outline: Check gift list search options works correctly
    Given User opens '<homePage>' page
    And User checks registry button visibility
    And User clicks registry button
    And User checks Registrant name input field visibility
    When User enter incorrect  name '<incorrectName>' into Registrant name field
    And User choose gift type'<typeOfGift>' from dropdown menu
    And User clicks button Search
    Then User checks that no gifts message '<noGifts>' is shown

    Examples:
      | homePage                 | incorrectName  |  typeOfGift          | noGifts                                |
      | https://www.amazon.com/  | dsgsdgsdgsd    |  Birthday Gift List  |Sorry, no Gift Lists match your search. |


  Scenario Outline: Check that User can shift to Amazon site in a specific country
    Given User opens '<homePage>' page
    And User checks Change of country button visibility
    When User clicks on Change of country button
    And User checks Go to website button visibility
    And User chooses country '<country>' from dropdown menu
    And User clicks on button Go to website
    And User switches to another window
    Then User checks that new web site Amazon logo contains county code '<countryCode>'
    And User checks that new site current url equals to expected Url '<expectedUrl>'

    Examples:
      | homePage                | country    | countryCode    | expectedUrl             |
      | https://www.amazon.com/ | Singapore  |  .sg           | https://www.amazon.sg/  |


  Scenario Outline: Check that item added to cart correctly
    Given User opens '<homePage>' page
    When User clicks the All menu
    And User clicks on Computers sub-menu
    And User clicks on Computers & Tablets sub-menu
    And User chooses HP brand checkbox for filtering
    And User clicks on first item after filtering
    And User clicks Add to cart button
    Then User checks items count '<cartItemsCount>' in the cart

    Examples:
      | homePage                | cartItemsCount  |
      | https://www.amazon.com/ | 1               |


  Scenario Outline: Check that currency change working correctly
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User checks actual type of currency '<actualTypeOfCurrency>'
    And User clicks Change currency button
    And User clicks currency settings drop - down menu
    And User choose another currency type '<newTypeOfCurrency>'
    And User clicks button Save changes
    Then User checks that product prise contains another currency type '<newTypeOfCurrency>'

    Examples:
      | homePage                 | searchWord    |actualTypeOfCurrency | newTypeOfCurrency  |
      | https://www.amazon.com/  | playstation 4 |$                    | BND                |
      | https://www.amazon.com/  | playstation 4 |$                    | COP                |


  Scenario Outline: Check language change working correctly
    Given User opens '<homePage>' page
    And User checks Language button visibility
    When User clicks Language button
    And User checks Save changes button visibility
    And User chooses the language '<language>' from list
    And User clicks button Save changes
    Then User checks that cart button text is translated '<translatedText>' as expected

    Examples:
      | homePage                | language     | translatedText   |
      | https://www.amazon.com/ | Português    | Carrinho         |
      | https://www.amazon.com/ | Deutsch      | Einkaufswagen    |


  Scenario Outline: Check that shipping location is correct
    Given User opens '<homePage>' page
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User checks Location button visibility
    And User clicks Location button
    And User chooses country of location '<locationCountry>' from dropdown menu in location popup
    And User clicks Done button
    Then User checks that first item from filtered list has correct shipping location '<locationCountry>'

    Examples:
      | homePage                | searchWord        | locationCountry   |
      | https://www.amazon.com/ | samsung galaxy    | South Africa      |


  Scenario Outline: Check that impossible to create new user account with empty email field
    Given User opens '<homePage>' page
    And User checks sign In button visibility
    And User clicks sign In button
    And User clicks Create your Amazon account button
    When User enter name '<name>' into Your name field
    And User enter password '<password>' into Password field
    And User enter password '<password>' into Re-enter Password field
    And User clicks continue button
    Then User checks that error message '<emailErrorMessage>' is shown

    Examples:
      | homePage                 | name        | password  | emailErrorMessage  |
      | https://www.amazon.com/  | Saddam      | 123456    |Enter your email    |





