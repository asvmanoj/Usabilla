@signing

Feature: As a user , I need to sign my document

Scenario: User try to sign invalid agreement record
Given I navigate to "signing.open.url"
  Then I maximize browser window
  Then I wait for 5 sec
  Then I take screenshot
  Then element having "SignYourDocuments_label" should have text as "Sign your document(s)"
  Then element having "PersonalSignCode_label" should have text as "Personal Sign Code"
  Then I wait for 5 sec
  Then I enter "18adeb7d-ee72-4902" into input field having "SignCode_text"
  Then I take screenshot
  Then I forcefully click on element having "Submit_button"
  Then I wait for 5 sec
  Then I take screenshot
  Then element having "No_agreement_found_msg" should have text as "No AgreementRecord found for this agreementId"
  

Scenario: User try to enter invalid agreement record
Given I navigate to "signing.open.url"
  Then I maximize browser window
  Then I wait for 5 sec
  Then I take screenshot
  Then element having "SignYourDocuments_label" should have text as "Sign your document(s)"
  Then element having "PersonalSignCode_label" should have text as "Personal Sign Code"
  Then I wait for 5 sec
  Then I enter "@#$214dfkd@%" into input field having "SignCode_text"
  Then I take screenshot
  Then I wait for 2 sec 
  Then element having "Invalid_Character_msg" should have text as "The code consists of characters a-z, A-Z, 0-9 and '-' only"
  
