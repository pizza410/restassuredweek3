Feature: testing student BDD

  Scenario:testing student CRUD operation
    When I send GET list request I receive full list
    And I try to acces data by ID
    And I create new data by following details
    |firstName|lastName|email|programme|cources|
    |shubham  |panchal |xyz123@gmail.com|Testing|Maths|
    And I fetch id number
    And I update that id numbers data as below
      |firstName|lastName|email|programme|cources|
      |vidhi  |patel |xyz123@gmail.com|Testing|selenium|