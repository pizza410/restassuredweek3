Feature: Testing different requests on the student application

  Scenario: Checking we can fetch data
    When I send GET request
    Then I should receive full list


    Scenario Outline:full crud operation
      When I create a new student by providing the information firstName "<firstname>"lastName"<lastName>"email"<email>"programme"<programme>"courses"<cources>"
      Then I verify with "<email>" is created

      Examples:
      |firstname|lastName|email|programme|cources|
      |shubham  |panchal |panchalshubh98@gmail.com|selenium|data|

    @new
   Scenario Outline:Update delete and recheck
    When I update data with firstName"<firstName>" lastName"<lastName>"email"<email>" programme "<programme>"course"<course>"
     And I verify the status code
     And I Delete that data
     And I verify using get request


     Examples:
     |firstName|lastName|email|programme|course|
     |Shubh    |Patel   |xyz123@gmail.com|Software|MAths|