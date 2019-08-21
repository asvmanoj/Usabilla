@signing

Feature: As a user , I need to sign my document

@requirementKey=IT3-RQ-68
Scenario: User sign the agreement record successfully
  Given I navigate to "signing.open.url"
  Then I maximize browser window
  Then I wait for 3 sec
  Then I take screenshot
  Then element having "SignYourDocuments_label" should have text as "Sign your document(s)"
  Then element having "PersonalSignCode_label" should have text as "Personal Sign Code"
  When I enter "43239f5f-0ad1-4fa7-ab1d-ad8f8a0e32ad" into input field having "SignCode_text"
  Then I wait for 2 sec
  Then I take screenshot
  When I forcefully click on element having "Submit_button"
  Then I wait for 3 sec
  Then I take screenshot
  Then element having "SignYourDocuments_header" should have text as "Sign your document(s)"
  Then element having "AgreementOVerview_label" should have text as "Agreement Overview"
  Then element having "Name_label" should have text as "Name"
  Then element having "CreatedOn_label" should have text as "Created on"
  Then element having "Signatures_label" should have text as "Signature(s)"
  Then I scroll to end of page
  Then I wait for 2 sec
  Then I take screenshot
  When I forcefully click on element having "ToOndertekenennl_button"
  Then I wait for 45 sec
  Then I take screenshot
  Then I forcefully click on element having "Next_Sign_button"
  Then I wait for 5 sec
  Then I take screenshot
  Then I forcefully click on element having "Sign_button"
  Then I wait for 45 sec
  Then element having "Success_message" should have text as "Success Message"
  Then element having "Success_message_complete" should have text as "you have successfully signed the agreement"
  Then I take screenshot
  Then I wait for 5 sec
  Then I scroll to end of page
  Then I take screenshot
  
  
  
  
  
