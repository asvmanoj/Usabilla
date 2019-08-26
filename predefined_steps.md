
## Navigation Steps

To open/close URL and to navigate between pages use following steps :

	Then I navigate to "([^\"]*)"

To switch between frames use following steps :	

	Then I switch to frame having (index|id|name|xpath|css) \"(.*?)
	Then I switch to main content
	
To interact with browser use following steps :    

	Then I maximize browser window


Assertion Steps
---------------

#### Steps For Asserting Element Text

To assert element text use any of the following steps :

	Then element having "([^\"]*)" should have partial text as "(.*?)
	
Input Steps
-----------

#### Steps For TextFields

To enter text into input field use following steps :

	When I enter "([^\"]*)" into input field having "([^\"]*)"


#### Steps For Dropdown List :

To select option by text from dropdown use following steps :

	When I select "(.*?)" option by text from dropdown having "(.*?)"


#### Steps For Multiselect List :

To select option by text from multiselect dropdown use following steps :

	When I select "(.*?)" option by text from multiselect dropdown having "(.*?)"

Click Steps
-----------
To click on web element use following steps :

	When I click on element having "(.*?)"

