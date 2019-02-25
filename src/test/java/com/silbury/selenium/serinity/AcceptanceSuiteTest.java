package com.silbury.selenium.serinity;


import org.junit.runner.RunWith;
import net.serenitybdd.jbehave.SerenityStories;

@RunWith(CustomSerenityReportingRunner.class)
public class AcceptanceSuiteTest extends SerenityStories 
{
    @Override
    protected String getRootPackage()
    {
    	return this.getClass().getPackage().getName();
    }
}
