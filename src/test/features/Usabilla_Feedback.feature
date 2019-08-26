@Usabilla
Feature: Generic and Specific feedback giving functionality
Scenario Outline: Verify that Generic and specific feedback functionality is visible in the screen
	Given I navigate to "application_url" 
	And I wait for 5 sec
	And I maximize browser window
	And I click on element having "feedback_Link"
  	And I wait for 5 sec
  	When I switch to frame having xpath "//iframe[@title='Usabilla Feedback Form Frame']"
  	Then element having <feedbackType> should have partial text as <expectedValue>
  	Then I take screenshot
  	
  	Examples:
    | feedbackType | expectedValue |
    |  "genericFeedback_Link"   |  "Generic feedback"  |
    |  "specificFeedback_Link"   |  "Specific feedback"  |
    

Scenario Outline: Verify the functionality of submitting a generic feedback
	Given I navigate to "application_url" 
	And I wait for 5 sec
	And I maximize browser window
	And I click on element having "feedback_Link"
  	And I wait for 5 sec
  	And I switch to frame having xpath "//iframe[@title='Usabilla Feedback Form Frame']"
  	And I click on element having "genericFeedback_Link"
  	And I click on element having <feedbackSmiley>
  	And I select <subject> option by text from dropdown having "subject_Select"
  	And I enter <comments> into input field having "comments_Text"
  	And I click on element having <recommendation>
  	When I click on element having "submit_Button"
  	Then element having "feedback_Message" should have partial text as "Thanks for leaving feedback!"
  	Then I take screenshot
  	
  		Examples:
    | feedbackSmiley | subject |comments| recommendation |
    |  "smileyLike_Element"   |  "Compliment"  | "Good feature" | "recommendation_Option_9" |
    |  "smileyLove_Element"   |  "Compliment"  | "Good feature" | "recommendation_Option_10" |
  	
  	
  	
    