Feature: Crude of products

  Scenario: Testing crud of productrs
    When I send get request i receive full info
    And I create a new Data using data below
      |name|type|price|shipping|upc|description|manufacturer|model|url|image|
      |shubham|panchal|12|25   |sdsd|eff       |efdew       |tesla|dfcef|wefef|
    And I fetch the information by id to verify
    And I update thet by id and following data
      |name|type|price|shipping|upc|description|manufacturer|model|url|image|
      |vidhi|patel|12|25   |sdsd|eff       |efdew       |tesla|dfcef|wefef|
    And I print firstname using id
    And I delete that data using ID
    Then  I verify Status code
