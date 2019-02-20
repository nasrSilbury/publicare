package com.silbury.selenium.serinity.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.silbury.selenium.common.Constants;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl(Constants.DefaultUrl.url)
public class HomePage extends PageObject {
	

	@FindBy(xpath = Constants.HeaderPage.headerInfoLinkXPath)
    private WebElement headerInfoName;
	
	@FindBy(xpath = Constants.FooterPage.footerPageXPath)
	private WebElement footerPageInfo;
	
	@FindBy(xpath = Constants.HeaderPage.defaultHeaderMenuXPath)
	private WebElement defaultHeaderMenu;
	
	@FindBy(xpath = Constants.HeaderPage.searchBarXPath)
	private WebElement searchBarInfo;
	
	@FindBy(xpath = Constants.HeaderPage.siteLinksXPath)
	private WebElement siteLinks;
	
	@FindBy(xpath = Constants.HeaderPage.loginButtonXPath)
	private WebElement loginButton;
	
	@FindBy(xpath = Constants.HeaderPage.languageDropdownXPath)
	private WebElement languageDropDown;
	
	@FindBy(xpath = Constants.DefaultMenuPage.productMenuXPath)
	private WebElement productMenu;
	
	@FindBy(xpath = Constants.DefaultMenuPage.servicesMenuXPath)
	private WebElement servicesMenu;
	
	@FindBy(xpath = Constants.DefaultMenuPage.publicareAcadamyMenuXPath)
	private WebElement publicareAcadamyMenu;
	
	@FindBy(xpath = Constants.DefaultMenuPage.Contact.iconCallXPath)
	private WebElement iconCall;
	
	@FindBy(xpath = Constants.DefaultMenuPage.Contact.iconEmailXPath)
	private WebElement iconEmail;
	
	@FindBy(xpath = Constants.DefaultMenuPage.Contact.iconAppointmentXPath)
	private WebElement iconAppointment;
	
	
	
	
 	public String getHeaderName() { 		
 		return headerInfoName.getAttribute("alt");		
	}

	public boolean isFooterPageVisible() {		
		return footerPageInfo.isDisplayed();
	}
	
	public int getDefaultHeaderPageMenuCount() {
		List<WebElement> webElementList = defaultHeaderMenu.findElements(By.tagName("a"));
		return webElementList.size();
	}

	public boolean isSearchBarVisible() {		
		return searchBarInfo.isDisplayed();
	}

	public List<String> lookForSiteLinks() {
		List<String> siteLinkList = new ArrayList<>();
		List<WebElement> webElementsList = siteLinks.findElements(By.tagName("a"));
		for(WebElement webElement : webElementsList) {
			siteLinkList.add(webElement.getText());
		}
		return siteLinkList;
	}

	public boolean lookForLanguageDropDownAndLoginButton() {
		return loginButton.isDisplayed() && languageDropDown.isDisplayed();		
	}

	public void clickOnMenuItems() {
		
		clickOnProductMenu();
		clickOnServicesMenu();	
		clickonPublicareAcadamyMenu();		
		
	}	

	public void clickOnSiteLinks() {
		
		clickOnAboutPublicCareLink();
		clickOnCareerLink();		
		clickOnContactLink();		 
		scrollToTop(); 
		clickOnLanguageDropDown();
		clickOnLoginButton();
	}

	public void clickLoginButton() {
		loginButton.click();		
	}

	private void clickonPublicareAcadamyMenu() {
		
		publicareAcadamyMenu.click();
		wait(Constants.WaitABit.TWO_SECONDS);
		
	}

	private void clickOnServicesMenu() {	
		servicesMenu.click();		
		wait(Constants.WaitABit.TWO_SECONDS);
	}

	private void clickOnProductMenu() {
		productMenu.click();
		wait(Constants.WaitABit.TWO_SECONDS);
		
	}
	
	private void scrollToTop() {
		getDriver().navigate().to(Constants.DefaultUrl.url);
     	JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("window.scrollBy(0,-250)", "");
		
	}

	private void clickOnLoginButton() {
		loginButton.click();
		wait(Constants.WaitABit.TWO_SECONDS);
	}

	private void clickOnAboutPublicCareLink() {
		siteLinks.findElement(By.xpath("a[1]")).click();
		wait(Constants.WaitABit.TWO_SECONDS);		
	}
	
	private void clickOnCareerLink() {
		siteLinks.findElement(By.xpath("a[2]")).click();
		wait(Constants.WaitABit.TWO_SECONDS);
		
	}

	private void clickOnContactLink() {
		siteLinks.findElement(By.xpath("a[3]")).click();
		wait(Constants.WaitABit.TWO_SECONDS);
		
	}
	
	private void clickOnLanguageDropDown() {
		
		languageDropDown.click();
		wait(Constants.WaitABit.TWO_SECONDS);	
		
	}

	public boolean lookForCallIconImages() {
		 return iconCall.isDisplayed() && iconCall.isEnabled();		
	}
	
	public boolean lookForEmailIconImages() {
		 return iconEmail.isDisplayed() && iconEmail.isEnabled();		
	}
	
	public boolean lookForAppointmentIconImages() {
		 return iconAppointment.isDisplayed() && iconAppointment.isEnabled();		
	}
		
	private void wait(int seconds) 
	{
		//waitABit(seconds);
	}

}
