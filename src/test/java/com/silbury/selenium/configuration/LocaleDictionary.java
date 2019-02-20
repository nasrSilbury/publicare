/*package com.silbury.selenium.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.silbury.selenium.common.Dictionary;
import com.silbury.selenium.utils.Util;

import java.io.File;
import java.util.HashMap;

*//**
 * @author <a href="mailto:nasrullah.syed@silbury.com">Nasrullah Syed</a>
 * @since 12/12/2018.
 *//*

public class LocaleDictionary extends AbstractConfiguration
{
    private static final Logger logger = LoggerFactory.getLogger(LocaleDictionary.class);
    public static final String COUNTRY_CONFIG_PATH =
            System.getProperty("com.siemens.lifenet.config.path");
    private static LocaleDictionary localeDictionary;

    private static String currentLocale;

    private Dictionary currentDictionary;

    private HashMap<String, Dictionary> dictionaries = new HashMap<>();

    private LocaleDictionary()
    {
        logger.info("\n\nLoading locale dictionary for selenium tests");
        final String filePath = DEFAULT_PATH + "locales";
        logger.info("File Path ====== "+filePath);
        File configDir = new File(filePath);
        readConfigurations(configDir);
    }

    public static LocaleDictionary getInstance()
    {
        if(localeDictionary == null)
        {
            localeDictionary = new LocaleDictionary();
        }

        return localeDictionary;
    }

    *//**
     * Set the current locale dictionary for a given user
     *
     * @param username The username of the user whose locale dictionary is to be set
     *//*
    public void activateUserLocale(String username)
    {
        String locale = getString(username);

        if(locale.equals(username))
        {
            logger.error(
                    "Username is not configured in the locales config file, or testing for " +
                    "invalid user");
            return;
        }
        if(!(locale).equals(currentLocale))
        {
            updateLocale(locale);
        }
    }

    private void updateLocale(String locale)
    {
        if(dictionaries.containsKey(locale))
        {
            currentDictionary = dictionaries.get(locale);
            currentLocale = locale;
        }
        else
        {
            updateDictionary(locale);
        }
    }

    private void updateDictionary(String locale)
    {
        //Read the country config
        String pathname = COUNTRY_CONFIG_PATH + File.separator + "lifenet" + "_" +
                          locale + ".config";

        logger.info("pathname locale dictionary:: " + pathname);
        File countryConfig = new File(pathname);
        readProperties(countryConfig);

        Dictionary dictionary = Dictionary.getDictionary(locale);
        dictionaries.put(locale, dictionary);
        currentDictionary = dictionary;
        currentLocale = locale;
    }

    *//**
     * Returns a Value from the Dictionary as String.
     *
     * @param key The Key for which the value should be retrieved.
     *
     * @return The value for the Key as a String.
     *//*
    public String translateKey(Object key)
    {
        return currentDictionary.getString(key);
    }

    public String translateKeyAndRemoveTags(Object key)
    {
        return Util.removeTagsFromString(translateKey(key));
    }
}
*/