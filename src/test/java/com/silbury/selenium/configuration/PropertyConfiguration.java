/*package com.silbury.selenium.configuration;

import java.io.File;

*//**
 * Reads Configuration files for the Step Definitions from the resource/config Directory.
 *
 * @author <a href="mailto:nasrullah.syed@silbury.com">Nasrullah Syed</a>
 * @since 30.11.18
 *//*
public class PropertyConfiguration extends AbstractConfiguration
{
    private static PropertyConfiguration configuration;

    private PropertyConfiguration()
    {
        String pathname = DEFAULT_PATH + "steps";
        System.out.println("path name in property config :: "+pathname);
        File configDir = new File(pathname);
        readConfigurations(configDir);
    }

    public static PropertyConfiguration getInstance()
    {
        if(configuration == null)
        {
            configuration = new PropertyConfiguration();
        }

        return configuration;
    }
}
*/