package com.silbury.selenium.configuration;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 

public class DriverConfiguration  extends AbstractConfiguration
{
 
	private static final long serialVersionUID = 1L;
	
	  private static final Logger logger = LoggerFactory.getLogger(DriverConfiguration.class);

	public DriverConfiguration(String driverFile)
    {
        String path = DEFAULT_PATH + driverFile + ".config";
        logger.info("path :: "+path);
        File file = new File(path);
        readConfiguration(file);
    }
}
