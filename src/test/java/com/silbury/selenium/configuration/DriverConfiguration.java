package com.silbury.selenium.configuration;

import java.io.File;
 

public class DriverConfiguration  extends AbstractConfiguration
{
 
	private static final long serialVersionUID = 1L;

	public DriverConfiguration(String driverFile)
    {
        String pathname = DEFAULT_PATH + driverFile + ".config";
        
        System.out.println("pathname :::: "+pathname);
        File file = new File(pathname);
        readConfiguration(file);
    }
}
