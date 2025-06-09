Feature: Auth Functionality
    @SignIn @SmokeTest @Web
    Scenario: Successful SignIn with valid credentials
        Given User is on the signin page
        When User enters valid username and password
        And User clicks the signin button
        Then User should be redirected to the homepage

    @Registration @Mobile @SmokeTest
    Scenario: Successful user registration
        Given User is on the registration page
        When User enters valid registration details
        And User submits the registration form
        Then User should see a success message