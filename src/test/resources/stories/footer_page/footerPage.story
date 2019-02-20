Meta:
@storyName FooterPage.story

Narrative: This story will test the footer page navigation

Scenario: testing footer page navigation and visibility
Given the user is on the Publicare home page
Then user scrolls down to bottom of page
And validates the visibility of Contact, opening hours, About Publicare, Public stories sections

Scenario: testing footer page newsletter section visibility
Given the user is on the Publicare home page
Then user scrolls down to bottom of page
And validates the visibility of newsletter section and a subscription button 

Scenario: testing footer page registration section visibility
Given the user is on the Publicare home page
Then user scrolls down to bottom of page
And validates the visibility of registration section with registration button 