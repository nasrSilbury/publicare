package com.silbury.selenium.serinity;


import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.annotations.Managed;



@RunWith(CustomSerenityReportingRunner.class)
public class AcceptanceTestSuite extends SerenityStories 
{
	@Managed(driver = "chrome")
    WebDriver browser;
	
	    @Override
	    protected String getRootPackage()
	    {
	   
	    	return this.getClass().getPackage().getName();
	    }
}
