package com.silbury.selenium.serinity.steps;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Then;

import com.silbury.selenium.serinity.pages.ProductPage;

public class ProductPageStepDefinitions {

	private ProductPage productPage;
	
	@Then("the user clicks on product")
	public void clickOnProductMenu() {
		productPage.clickOnProductPage();
	}
	
	@Then("user click on first menu element in product page")
	public void clickOnFirstMenuElementOnProductPage()
	{
		productPage.clickOnFirstMenuElementOnProductPage();
	}

	@Then("verifies details of first menu element page is visible on right panel")
	public void verifyTheFirstMenuElementDetails()
	{
		boolean isDisplayed = productPage.verifyTheFirstMenuElementDetails();
		assertThat(isDisplayed, is(true));
	}
	
	
	@Then("user click on first element in first menu element in product page")
	public void clickOnFirstElementInFirstMenuElementOnProductPage()
	{
		productPage.clickOnFirstElementInFirstMenuElementOnProductPage();
	}
	
	@Then("verifies details of first element in first menu page is visible on right panel")
	public void verifyTheFirstElementDetailsOfFirstMenu()
	{
		boolean isDisplayed = productPage.verifyTheFirstElementDetailsOfFirstMenu();
		assertThat(isDisplayed, is(true));
	}
	
	@Then("user navigates back to first menu element")
	public void navigateBackToFirstMenuElement()
	{
		productPage.navigateBackToFirstMenuElement();
	}
	
	@Then("to main product page")
	public void navigateBackToMainProductPage()
	{
		productPage.navigateBackToMainProductPage();
	}
	
}
