package com.silbury.selenium.serinity;

import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;

import net.serenitybdd.jbehave.runners.SerenityReportingRunner;

public class CustomSerenityReportingRunner extends SerenityReportingRunner
{
    public CustomSerenityReportingRunner(
            Class<? extends ConfigurableEmbedder> testClass) throws Throwable
    {
        super(testClass);
    }

    public CustomSerenityReportingRunner(
            Class<? extends ConfigurableEmbedder> testClass,
            ConfigurableEmbedder embedder) throws Throwable
    {
        super(testClass, embedder);
    }

    @Override
    protected Configuration getConfiguration()
    {
        Configuration configuration = super.getConfiguration();
        configuration.storyControls().doIgnoreMetaFiltersIfGivenStory(true);
       

        return configuration;
    }
}
