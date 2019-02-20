package com.silbury.selenium.serinity.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.silbury.selenium.common.Constants;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
@DefaultUrl(Constants.DefaultUrl.url)
public class FooterPage extends PageObject {

	@FindBy(xpath = Constants.FooterPage.contactSectionXPath)
    private WebElement contactSection;
	
	@FindBy(xpath = Constants.FooterPage.openingHoursSectionXPath)
    private WebElement openingHoursSection;
	
	@FindBy(xpath = Constants.FooterPage.aboutPublicareSectionXPath)
    private WebElement aboutPublicareSection;
	
	@FindBy(xpath = Constants.FooterPage.publicStoriesSectionXPath)
    private WebElement publicStoriesSection;
	
	@FindBy(xpath = Constants.FooterPage.NewsLetter.newsLetterSectionXPath)
    private WebElement newsLetterSection;
	
	@FindBy(xpath = Constants.FooterPage.NewsLetter.titleSectionXPath)
    private WebElement newsLetterTitleSection;
	
	@FindBy(xpath = Constants.FooterPage.NewsLetter.subscribeButtonXPath)
    private WebElement newsLetterSubscribeButtonSection;
	
	@FindBy(xpath = Constants.FooterPage.Registration.registerNowAndOrderButtonXPath)
    private WebElement registerNowAndOrderButton;
	
	public void scrollToPageBottom() {		
		getDriver().navigate().to(Constants.DefaultUrl.url);
     	JavascriptExecutor jse = (JavascriptExecutor) getDriver();			
		jse.executeScript("window.scrollBy(0,1000)");
	}

	public boolean evaluateFooterInformation() {
		
		return (openingHoursSection.isDisplayed() 
				&& aboutPublicareSection.isDisplayed() 
				&& publicStoriesSection.isDisplayed() 
				&& contactSection.isDisplayed());
		
	}

	public boolean evaluateNewsLetterSection() {
		
		return (newsLetterSection.isDisplayed()
				&& newsLetterTitleSection.isDisplayed()
				&& newsLetterSubscribeButtonSection.isDisplayed()
				&& newsLetterSubscribeButtonSection.isEnabled());		
	}

	public boolean evaluateRegistrationAndOrderSection() {		 
		return registerNowAndOrderButton.isDisplayed() && registerNowAndOrderButton.isEnabled();
	}

}
