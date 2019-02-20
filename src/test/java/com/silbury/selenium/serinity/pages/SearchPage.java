package com.silbury.selenium.serinity.pages;

import org.openqa.selenium.WebElement;

import com.silbury.selenium.common.Constants;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
@DefaultUrl(Constants.DefaultUrl.url)
public class SearchPage extends PageObject {
	
	@FindBy(xpath = Constants.SearchArea.searchAreaTextXPath)
	private WebElement searchAreaText;
	
	@FindBy(xpath = Constants.SearchArea.searchAreaSubmitButtonXPath)
	private WebElement searchAreaSubmitButton;
	
	@FindBy(xpath = Constants.SearchArea.searchResultsXPath)
	private WebElement searchResults;
	
	@FindBy(xpath = Constants.SearchArea.searchResultsCountTextXPath)
	private WebElement searchResultsCountText;
	

	public void clickOnSearchTextArea() {
		searchAreaText.click();		
	}

	public String getSearchResultsForGivenText(String searchText) {
		searchAreaText.sendKeys(searchText);
		searchAreaSubmitButton.click();
		return searchResults.getText();
		
	}

	public boolean validateForNoOfResultsTextDisplay() {
		return searchResultsCountText.isDisplayed();	
	}

}
