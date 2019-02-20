Meta:
@storyName SearchPage.story

Narrative: This story will perform search operations

Scenario: perform search operation
Given the user is on the Publicare home page
Then looks for search bar at the right corner
And clicks on search test area
And enter the search keyword 'beutel' and check for results
And validates for the no of results test display