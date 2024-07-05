Feature: student 2 CRUD operation

  Scenario: Performing full crud operation
    When I send Get request I received full data
    And I fetchdata by providing specific ID
    And I create Data by passing followingdata
    |firstName|lastName|email|programme|courses|
    |vidhi  |panchal |xyz123@gmail.com|selenium|data|
    And I verify Data has been created successfully
    And I extract student ID
    And I extract that data using id and update that data using following data
      |firstName|lastName|email|programme|courses|
      |Shubham  |patel |xyz123@gmail.com|selenium|data|
    And I delete the data of same ID
    Then I try to fetch the same data

