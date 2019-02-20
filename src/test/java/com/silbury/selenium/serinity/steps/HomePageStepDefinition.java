package com.silbury.selenium.serinity.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.List;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import com.silbury.selenium.serinity.pages.HomePage;

public class HomePageStepDefinition {
	
	private HomePage homePage;

    
   @Given("the user is on the Publicare home page")
    public void givenTheUserIsOnThePablicareHomePage() {
    	homePage.open();
    }

   @Then("the user looks up the page header with title '$title'")
    public void thenTheyShouldHomepageHeader(String title) {
        String homePageName = homePage.getHeaderName();
        assertThat(homePageName, is(title));
    }
   
   @Then("validated the visibility of footer page")
   public void validateTheFooterPageVisibility() {
	   boolean footerPage = homePage.isFooterPageVisible();
	   assertThat(footerPage, is(true));
   }
   
   @Then("the user checks for default menu headers with count as '$count'")
   public void checkForDefaultMenuHeadersAndCount(int count) {
	   int defaultHeaderMenuCount = homePage.getDefaultHeaderPageMenuCount();
	   assertThat(count, is(defaultHeaderMenuCount));
   }
   
   @Then("looks for search bar at the right corner")
   public void lookForSearchBar(){
	   boolean isSearchBarVisible = homePage.isSearchBarVisible();
	   assertThat(isSearchBarVisible, is(true));
   }
   
   @Then("the user checks for home page links like '$linkNames'")
   public void lookForSiteLinks(List<String> linkNames) {
	   List<String> siteLinkNames = homePage.lookForSiteLinks();
	   for(String linkName : linkNames) {
		   Assert.assertTrue(siteLinkNames.contains(linkName));
	   }
   }
   
   @Then("looks for language dropdown and login button")
   public void lookForLanguageDropDownAndLoginButton() {
	   boolean isDisplayed = homePage.lookForLanguageDropDownAndLoginButton();
	   assertThat(isDisplayed, is(true));
   }
   
   @Then("looks for icons with call, email, appointment images")
   public void lookForCallEmailAppointmentImages() {
	   assertThat(homePage.lookForCallIconImages(), is(true));
	   assertThat(homePage.lookForEmailIconImages(), is(true));
	   assertThat(homePage.lookForAppointmentIconImages(), is(true));	   
   }
   
   @Then("the user clicks on menu items respectively")
   public void clickOnMenuItems() {
	   homePage.clickOnMenuItems();
   }
	 
   @Then("clicks on home page links like '$LinkNames'")
   public void clickOnSiteLinks(List<String> linkNames) {
	   homePage.clickOnSiteLinks();
   }
   
   @Then("clicks login button")
   public void clickLoginButton() {
	   homePage.clickLoginButton();
   }

}
