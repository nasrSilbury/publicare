Meta:
@storyName HomePage.story

Narrative: This story will test the home page navigation

Scenario: testing home page navigation
Given the user is on the Publicare home page
Then the user looks up the page header with title 'Publicare'
And validated the visibility of footer page

Scenario: validating menus in home page
Given the user is on the Publicare home page
Then the user checks for default menu headers with count as '3'
And looks for search bar at the right corner

Scenario: validate the visibility of site links in home page
Given the user is on the Publicare home page
Then the user checks for home page links like 'Über Publicare,Karriere,Kontakt' 
And looks for language dropdown and login button
And looks for icons with call, email, appointment images

Scenario: click and check all links in home page to validate any breaks
Given the user is on the Publicare home page
Then the user clicks on menu items respectively 
And clicks on home page links like 'Über Publicare,Karriere,Kontakt,language' 
And clicks login button
