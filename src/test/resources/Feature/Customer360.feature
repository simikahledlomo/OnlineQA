Feature: Login page automation of demo app
  Scenario: Check loginis successful with valid creds
    Given Customer360  baseURL "https://customer360.ekurhuleni.gov.za/Customer360" browser "chrome"
    When User enters valid username "JayKay" and passwod "Passw0rd1@" and click login button
    Then User clicks Apply
    Then User clicks pay
    Then User clicks Find
    Then User clicks connect
    Then User clicks search
    And User clicks home
    Then User select account on drop down list "2201679230 - Comissioner Street"
    Then User select meter number on drop down list "211086900 - Water Current"
    And User select start date on the date picker "2022/07/24"
    And User select end date on the date picker "2023/11/24"
    And User clicks Show button
    Then User clicks log out
    And Good Bye browser