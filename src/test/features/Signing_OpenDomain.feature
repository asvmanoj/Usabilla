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
  When I enter "7a774965-5e95-4a8c-b0ca-c1b8a5d78586" into input field having "SignCode_text"
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
  Then I wait for 30 sec
  When I forcefully click on element having "Next_Sign_button"
  #Then element having "Consent_label" should have text as "Consent to document"
  Then I wait for 10 sec
  Then I take screenshot
  Then I forcefully click on element having "Sign_button"
  Then I wait for 40 sec
  Then element having "Success_message" should have text as "Success Message"
  Then element having "Success_message_complete" should have text as "you have successfully signed the agreement"
  Then I take screenshot
  Then I wait for 5 sec
  Then I scroll to end of page
  Then I take screenshot
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
