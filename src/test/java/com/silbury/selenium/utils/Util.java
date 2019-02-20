package com.silbury.selenium.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.silbury.selenium.common.Constants;
import com.silbury.selenium.exception.InvalidConfigurationException;

import net.serenitybdd.core.annotations.findby.By;
 

public class Util {
    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    /**
     * Checks which of the two strings exists in a line
     *
     * @param line the line in which strings to be searched for
     * @param either first string
     * @param or second string
     * @return
     */
    public static String getContainsEitherOr(String line, String either, String or)
    {
        return line.contains(either) ? either : line.contains(or) ? or : null;
    }

    /**
     * extracts the text from org.openqa.selenium.WebElement array and put in a string array
     *
     * @param elements List of org.openqa.selenium.WebElement
     * @return list of strings
     */
    public static List<String> getNameList(List<WebElement> elements)
    {
        List<String> names = new ArrayList<>();
        for(WebElement element : elements)
        {
            names.add(element.getText().trim());
        }
        return names;
    }

    /**
     * takes a list of strings, remove a pattern existing in the string
     *
     * @param list List of strings to be checked
     * @param regex the pattern needed to be removed from string
     * @return list of string without the pattern
     */
    public static List<String> extractRemovePatterns(List<String> list, String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        List<String> names = new ArrayList<>();
        for(String name : list)
        {
            try
            {
                matcher = pattern.matcher(name);
                matcher.find();
                names.add(name.substring(matcher.end()).trim());
            }
            catch(IllegalStateException e)
            {
                System.err.println("pattern not found for : " + name);
            }

        }
        return names;
    }

    /**
     * look for a pattern in the string
     *
     * @param string the string to be checked
     * @param regex the pattern to be matched
     * @param i position of the matched patterns to return
     * @return returns the i'th position of the matched patterns
     */
    public static String extractPattern(String string, String regex, int i)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        matcher.find();
        return matcher.group(0);
    }

    /**
     * checks if the strings are in ascending
     *
     * @param str1 first string
     * @param str2 second string
     * @return true if ascending else return false
     */
    public static boolean isAscending(String str1, String str2)
    {
        return str1.compareToIgnoreCase(str2) <= 0;
    }

    /**
     * checks if the strings are in descending
     *
     * @param str1 first string
     * @param str2 second string
     * @return true if descending else return false
     */
    public static boolean isDescending(String str1, String str2)
    {
        return str1.compareToIgnoreCase(str2) >= 0;
    }
 

    /**
     * Clean up the list of webelements containing closer or divider elements
     * @param elements List of org.openqa.selenium.WebElement
     * @return list of elements with all closer and dividers removed
     */
    public static List<WebElement> cleanup(List<WebElement> elements)
    {
        String cssClassType;
        Iterator<WebElement> it = elements.iterator();
        while(it.hasNext())
        {
            WebElement webElement = it.next();
            cssClassType = webElement.getAttribute("class");
            if(cssClassType == null || cssClassType.contains("closer") ||
               cssClassType.contains("divider") ||
               "".equals(cssClassType))
            {
                it.remove();
            }
        }
        return elements;
    }

    /**
     * split a string using a pattern and return the value from a desired position
     * @param string the string to be split
     * @param pattern pattern used to split the string
     * @param position the position of the split array to be returned
     * @return the string form the desired position of splited array
     */
    public static String extractFromString(String string, String pattern, int position)
    {
        return string.split(pattern)[position].trim();
    }

    public static List<String> extractLinks(List<WebElement> hrefElements)
    {
        List<String> hrefLinks = new ArrayList<>();
        for(WebElement element : hrefElements)
        {
            hrefLinks.add(element.findElement(By.tagName("a")).getAttribute("href"));
        }
        return hrefLinks;
    }

    /**
     * this method has some issues - e.g. if a element has been there once but then disappears
     * (also the thml disappears) then you can get a "stale" exception.
     * @param element
     * @return
     */
    public static boolean isElementDisplayed(WebElement element)
    {
        try
        {
            element.getTagName();
            return true;
        }
        catch(ElementNotVisibleException | NoSuchElementException | NullPointerException e)
        {
            return false;
        }
    }

/*    public static List<String> translateList(List<String> details)
    {
        LocaleDictionary dictionary = LocaleDictionary.getInstance();
        List<String> translatedList = new ArrayList<>();
        for(String key : details)
        {
            translatedList.add(dictionary.translateKey(key));
        }
        return translatedList;
    }
*/
/*    public static List<String> getValueFromConfiguration(List<String> details)
    {
        PropertyConfiguration configuration = PropertyConfiguration.getInstance();
        List<String> translatedList = new ArrayList<>();
        for(String key : details)
        {
            translatedList.add(configuration.getString(key));
        }
        return translatedList;
    }*/

    /**
     * otherwise the select didn't work for edge browser (no onchange event)
     * @param element
     * @param optionToChoose
     */
    public static void typeFirstLettersInDropDown(WebElement element, String optionToChoose)
    {
        element.sendKeys(optionToChoose);
    }

    /**
     * Reads a config file where key and value pair are separated by '::'
     * @param configFile configFile
     * @return Map
     */
    public static Map<String, Object> readConfigFile(File configFile)
    {
        Map<String, Object> map = new HashMap<>();
        if(configFile.isFile())
        {
            BufferedReader reader = null;
            try
            {
                reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(configFile)));
                String line;
                String[] keyValue;
                while((line = reader.readLine()) != null)
                {
                    if(!line.startsWith("#") && !"".equals(line.trim()))
                    {
                        keyValue = line.split("::");
                        if(keyValue.length < 2)
                        {
                            throw new InvalidConfigurationException(line);
                        }
                        map.put(keyValue[0], keyValue[1]);
                    }
                }
            }
            catch(IOException | InvalidConfigurationException e)
            {
                logger.error("Failed to read config file.", e);
            }
            finally
            {
                try
                {
                    if(reader != null)
                    {
                        reader.close();
                    }
                }
                catch(IOException e)
                {
                    //if configuration fails tests may run but will fail
                    //so test should be abandoned.
                    logger.error("Failed to close reader.", e);
                }
            }
        }
        return map;
    }

    /**
     * Reads the properties file
     *
     * @param propertyFile File
     * @return Map
     */
    public static Map readProperties(File propertyFile)
    {
        Properties tempProperties = new Properties();
        // sometimes config  should not exist, e.g for invalid user.
        if(!propertyFile.exists())
        {
            logger.error("error loading properties.");
            logger.error(
                    " no file " + propertyFile.getAbsolutePath() + ", " + propertyFile.getName());
            return tempProperties;
        }
        logger.trace("Read The properties from " + propertyFile);
        InputStream inputStream = null;
        try
        {
            inputStream = new FileInputStream(propertyFile);
            tempProperties.load(inputStream);
        }
        catch(IOException e)
        {
            logger.error("error loading properties.", e);
        }
        finally
        {
            try
            {
                if(inputStream != null)
                {
                    inputStream.close();
                }
            }
            catch(IOException e)
            {
                logger.error("error loading properties.", e);
            }
        }

        return tempProperties;
    }

    /**
     * Get the country from the locale
     *
     * @param locale String
     * @return String
     */
    public static String getCountryFromLocale(String locale)
    {
        String[] strings = locale.split("_");
        return strings[1];
    }

    /**
     * Get the first word of the string separated by space
     *
     * @param text String separated by space
     * @return first word after splitting them
     */
    public static String extractFirstWordOfStringSeparatedBySpace(String text)
    {
        String[] strings = text.split(" ");

        return strings[0];
    }

    public static String removeTagsFromString(String string)
    {
		return string.replaceAll(Constants.TAG_START_CLOSE_BR_REGEX, "");
    }
}
