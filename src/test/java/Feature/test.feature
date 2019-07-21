Feature: Ability to buy the all sort of Merchandise on the portal
  Verify if user is able to place an order on the portal



  Scenario: Place an order on chrome brower
    Given user is on "https://shop.mercedes-benz.com/en-gb/collection/" homepage and using "Chrome" browser
    When user select a product and is on shopping basket
    And user enters First name as "Amresh", Lastname as "Varshney",Number as "3",street as "Sloane apartment",City as "London",Post code as "SP2 0FL",Email as "amresh01@gmail.com"
    Then user is taken to Verification and order placement screen