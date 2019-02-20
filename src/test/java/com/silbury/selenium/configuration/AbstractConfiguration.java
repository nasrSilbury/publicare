package com.silbury.selenium.configuration;

import java.io.File;
import java.util.HashMap;

import com.silbury.selenium.common.Constants;
import com.silbury.selenium.utils.Util;

 
 

public class AbstractConfiguration  extends HashMap<String, Object>{
	
	private static final long serialVersionUID = 2388382274224886485L;
	protected static final String DEFAULT_PATH =
            Constants.RESOURCES_ROOT + "config" + File.separator;
 
    /**
     * Reads all the configuration files with in the directory
     *
     * @param dir Contains the config files.
     */
    protected void readConfigurations(File dir)
    {
        File[] files = new File[0];
        if(dir.exists())
        {
            files = dir.listFiles();
        }
        if(files != null)
        {
            for(File configFile : files)
            {
                readConfiguration(configFile);
            }
        }

    }
    

    /**
     * Read the property file and add it to the current configuration
     *
     * @param propertyFile File
     */
    public void readProperties(File propertyFile)
    {
        putAll(Util.readProperties(propertyFile));
    }

    /**
     * Reads Key/Value Pairs from the specified file separated by '::'.
     *
     * @param configFile File
     */
    public void readConfiguration(File configFile)
    {
        putAll(Util.readConfigFile(configFile));
    }

    /**
     * Returns a Value from the Configuration as String.
     *
     * @param key The Key for which the value should be retrieved.
     *
     * @return The value for the Key as a String.
     */
    public String getString(Object key)
    {
        Object value = get(key);

        if(value != null)
        {
            return value.toString();
        }
        else
        {
            return key.toString();
        }
    }

}
