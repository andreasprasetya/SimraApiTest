Feature: LogOut
  @SignIn @SmokeTest @Web
  Scenario: Successful SignIn with valid credentials
    Given User is on the signin page
    And User clicks the logout menu
    Then User should be redirected to the homepage
