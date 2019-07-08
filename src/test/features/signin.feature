@signi
Feature: As a user , I need to see my docs

  Scenario: entering valid values
  Given I navigate to "signin.url"
  When I enter "7842a44d-af76-444e-9706-0cb9ee59dbce" into input field having "sigin_id"
  When I forcefully click on element having "submit_button"
  Then I wait for 5 sec
  Then I take screenshot