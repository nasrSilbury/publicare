package com.silbury.selenium.serinity.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Then;

import com.silbury.selenium.serinity.pages.FooterPage;

public class FooterPageStepDefinition {

	private FooterPage footerPage;
	
	@Then("user scrolls down to bottom of page")
	public void scrollToPageBottom() {
		footerPage.scrollToPageBottom();
	}
	
	@Then("validates the visibility of Contact, opening hours, About Publicare, Public stories sections")
	public void evaluateFooterContactInformation() {
		boolean isVisible = footerPage.evaluateFooterInformation();
		assertThat(isVisible, is(true));
	}
	
	@Then("validates the visibility of newsletter section and a subscription button")
	public void evaluateNewsLetterSection() {
		boolean isVisible =footerPage.evaluateNewsLetterSection();
		assertThat(isVisible, is(true));
	}
	
	@Then("validates the visibility of registration section with registration button")
	public void evaluateRegistrationAndOrderSection() {
		boolean isVisible = footerPage.evaluateRegistrationAndOrderSection();
		assertThat(isVisible, is(true));
	}
}

