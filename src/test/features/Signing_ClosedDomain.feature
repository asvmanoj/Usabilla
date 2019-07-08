@signin

Feature: As a user , I need to sign my document

Scenario: User sign the agreement record successfully
  Given I navigate to "signing.closed.url"
  Then I maximize browser window
  Then I wait for 3 sec
  Then I take screenshot
  Then element having "SignYourDocuments_label" should have text as "Sign your document(s)"
  Then element having "PersonalSignCode_label" should have text as "Personal Sign Code"
  When I enter "18adeb7d-ee72-4902-8fa7-f8ad34d39590" into input field having "SignCode_text"
  Then I wait for 2 sec
  Then I take screenshot
  When I forcefully click on element having "Submit_button"
  Then I wait for 3 sec
  Then I take screenshot
  Then element having "SignYourDocuments_header" should have text as "Sign your document(s)"
  Then element having "AgreementOVerview_label" should have text as "Agreement Overview"
  Then element having "Name_label" should have text as "Name"
  #Then element having "CreatedOn_label" should have text as "Created on"
  Then element having "Signatures_label" should have text as "Signature(s)"
  Then I scroll to end of page
  Then element having "Back_button" should have text as "Back"
  Then element having "Next_button" should have text as "Next"
  Then I wait for 2 sec
  Then I take screenshot
  When I forcefully click on element having "Next_button"
  Then I scroll to end of page
  Then I wait for 2 sec
  Then I take screenshot
  When I forcefully click on element having "ToOndertekenennl_button"
  Then I wait for 15 sec
  When I forcefully click on element having "click_page"
    Then I wait for 5 sec
  #Then element having "Back_button" should have text as "Back"
  #Then element having "Next_button" should have text as "Next"
  #Then element having "Next_button" should have text as "Next"
   When I forcefully click on element having "Next"
  Then I take screenshot
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  