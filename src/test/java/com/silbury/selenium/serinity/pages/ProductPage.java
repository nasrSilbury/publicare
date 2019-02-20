package com.silbury.selenium.serinity.pages;

import org.openqa.selenium.WebElement;

import com.silbury.selenium.common.Constants;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
@DefaultUrl(Constants.DefaultUrl.url)
public class ProductPage extends PageObject {
	
	@FindBy(xpath = Constants.ProductPage.productMenuXPath)
	private WebElement productMenu;
	
	@FindBy(xpath = Constants.ProductPage.navigateBackToProductPageXPath)
	private WebElement navigateBackToProductPage;
	
	@FindBy(xpath = Constants.ProductPage.productFirstMenuElementXPath)
	private WebElement productFirstMenuElement;
	
	@FindBy(xpath = Constants.ProductPage.productFirstMenuElementDetailsXPath)
	private WebElement productFirstMenuElementDetails;
	
	@FindBy(xpath = Constants.ProductPage.navigateBackToFirstMenuElementXPath)
	private WebElement navigateBackToFirstMenuElement;	
	
	@FindBy(xpath = Constants.ProductPage.productFirstElementInFirstMenuXPath)
	private WebElement productFirstElementInFirstMenu;
	
	@FindBy(xpath = Constants.ProductPage.productFirstElementInFirstMenuDetailsXPath)
	private WebElement productFirstElementInFirstMenuDetails;
	
	

	public void clickOnProductPage() {
		productMenu.click();		
	}

	public void clickOnFirstMenuElementOnProductPage() {
		productFirstMenuElement.click();
		
	}
	
	public boolean verifyTheFirstMenuElementDetails() {
		return productFirstMenuElementDetails.isDisplayed();
	}

	public void clickOnFirstElementInFirstMenuElementOnProductPage() {
		productFirstElementInFirstMenu.click();		
	}

	public boolean verifyTheFirstElementDetailsOfFirstMenu() {
		return productFirstElementInFirstMenuDetails.isDisplayed();		
	}

	public void navigateBackToFirstMenuElement() {
		navigateBackToFirstMenuElement.click();
		
	}

	public void navigateBackToMainProductPage() {
		navigateBackToProductPage.click();		
	}

}
