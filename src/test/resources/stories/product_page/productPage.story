Meta:
@storyName ProductPage.story

Narrative: This story will test the product page navigation

Scenario: Testing product page navigation
Given the user is on the Publicare home page
Then the user clicks on product
Then user click on first menu element in product page
And verifies details of first menu element page is visible on right panel
Then user click on first element in first menu element in product page
And verifies details of first element in first menu page is visible on right panel
Then user navigates back to first menu element 
And to main product page