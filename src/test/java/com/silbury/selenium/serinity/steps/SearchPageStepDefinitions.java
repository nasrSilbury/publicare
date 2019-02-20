package com.silbury.selenium.serinity.steps;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Then;

import com.silbury.selenium.serinity.pages.SearchPage;

public class SearchPageStepDefinitions {
	
	private SearchPage searchPage;
	
	@Then("clicks on search test area")
	public void clickOnSearchTextArea()
	{
		searchPage.clickOnSearchTextArea();
	}

	@Then("enter the search keyword '$searchText' and check for results")
	public void getSearchResultsForGivenText(String searchText)
	{
		String searchResultsForText = searchPage.getSearchResultsForGivenText(searchText);
		assertThat(searchResultsForText, containsString(searchText));
	}
	
	@Then("validates for the no of results test display")
	public void validateForNoOfResultsTextDisplay()
	{
		boolean flag =  searchPage.validateForNoOfResultsTextDisplay();
		assertThat(flag, is(true));
	}
}
