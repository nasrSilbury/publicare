package com.silbury.selenium.common;

import java.io.File;

public interface Constants {
	

    String RESOURCES_ROOT = "src" + File.separator + "test" 
    						+ File.separator + "resources" + File.separator;

    //String SELENIUM_CONFIG_PATH = "../../angular4/src/assets/data";
 

    String DOWNLOADPATH = System.getProperty("user.home") + File.separator + "Downloads";
    String DESCENDING = "glyphicon-arrow-up";
    String ASCENDING = "glyphicon-arrow-down";
    CharSequence ICON_TOOL_BAR_OPEN = "icon-globe";
    String TAG_START_CLOSE_BR_REGEX = "<\\s*\\w.*?>|<\\s*\\/\\s*\\w\\s*.*?>|<\\s*br\\s*>";

    String BODY_TAG_NAME = "body"; 

    enum NavTabNameAndPattern
    {
        PRODUCTS_MENU("/produkte"),
        SERVICES_MENU("/dienstleistungen"),
        PUBLICARE_ACADAMY("/publicare-academy");
        
        private final String urlPattern;

        NavTabNameAndPattern(String urlPattern)
        {
            this.urlPattern = urlPattern;
        }

        public String getUrlPattern()
        {
            return urlPattern;
        }
    }

    enum DriverName
    {
        FIREFOX,
        CHROME,
        WEBDRIVER,
        IE,
        CHROME_MOBILE,
        EDGE
    }

    enum DriverType
    {
        LOCAL,
        REMOTE
    }

    enum SystemType
    {
        DESKTOP,
        MOBILE
    }

    enum CalendarViewType
    {
        MONTH,
        YEAR
    }
    
    interface SearchArea
    {
    	String searchAreaTextXPath = "//input[@id='edit-search-api-fulltext']";
    	
    	String searchAreaSubmitButtonXPath = "//input[@id='edit-submit-publicare-search']";
    	
    	String searchResultsXPath = "//h1[@class='margin-top-0']";
    	
    	String searchResultsCountTextXPath = "//div[@class='search-meta']//p";
    }

    interface WaitABit
    {
    	int TWO_SECONDS = 2000;
    	int THREE_SECONDS = 3000;
    	int FOUR_SECONDS = 4000;
    	int FIVE_SECONDS = 5000;	
    }
     
    interface DefaultUrl
    {
    	String url = "http://publicaretest2qpck2mqd5.devcloud.acquia-sites.com/de";
    }

    interface HeaderPage
    {
        String headerInfoLinkXPath = "/html[1]/body[1]/main[1]/header[1]/div[1]/a[1]/picture[1]/img[1]";
        
        String defaultHeaderMenuXPath = "//nav[@class='nav nav--main']";

		String searchBarXPath = "//div[@class='search-bar']";

		String siteLinksXPath = "//nav[@class='nav nav--top hide-on-mobile']";

		String loginButtonXPath = "//div[@id='user-switch']//a[@type='button']";
		
		String languageDropdownXPath = "//div[@class='language_wrapper_js is-active']//div[@class='dropbutton-widget']";
    }
    
    interface ProductPage
    {
    	String productMenuXPath = "/html[1]/body[1]/main[1]/header[1]/div[1]/div[1]/div[1]/nav[1]/a[1]";
    	
    	String productFirstMenu = "//body/main[@id='panel']/div[@class='dialog-off-canvas-main-canvas']/div[@id='after-header']";
    	
    	String navigateBackToProductPageXPath = "//a[@class='nav--side__link nav--side__link--back']";
    							   
    	String productFirstMenuElementXPath       = productFirstMenu + "/nav[@class='nav nav--side']/div[1]";
    	
    	String productFirstMenuElementDetailsXPath = "//div[@class='category-value']";
    	
    	String navigateBackToFirstMenuElementXPath = productFirstMenu + "/nav[@id='product-slug-term']/a[2]";
    	
    	String productFirstElementInFirstMenuXPath = "//nav[@id='product-slug-term']//div[1]//span[1]"; 
    	
    	String productFirstElementInFirstMenuDetailsXPath = "//div[@class='product-list']";
    }

    
    interface DefaultMenuPage
    {
    	String defaultMenu = "/html[1]/body[1]/main[1]/header[1]/div[1]/div[1]/div[1]/nav[1]/";
    	
    	String productMenuXPath          = defaultMenu + "a[1]";
    	
    	String servicesMenuXPath 		 = defaultMenu + "a[2]";
    	
    	String publicareAcadamyMenuXPath = defaultMenu + "a[3]";
    	
    	interface Contact
    	{
    		String iconCallXPath = "//div[@class='contact-bar']//a[1]";
    		
    		String iconEmailXPath = "//div[@class='contact-bar']//a[2]";
    		
    		String iconAppointmentXPath = "//div[@class='contact-bar']//a[3]";
    	}
    	
    }

    interface FooterPage
    {
		String footerPageXPath = "//footer[@class='footer']";
		String contactSectionXPath = "//div[@class='footer-top']//div[1]//div[1]";
		String openingHoursSectionXPath = footerPageXPath + "//div[@class='wrap']//div[2]//div[2]";
		String aboutPublicareSectionXPath = footerPageXPath + "//div[@class='wrap']//div[3]//div[3]";
		String publicStoriesSectionXPath = footerPageXPath + "/div[@class='wrap']/div[@class='footer-top']/div[4]";
		//String publicStoriesSectionXPath = "//body/main[@id='panel']/div[@class='dialog-off-canvas-main-canvas']/footer[@class='footer']/div[@class='wrap']/div[@class='footer-top']/div[4]";
		
		interface NewsLetter
		{
			String newsLetterSectionXPath = "//div[@class='footer-newsletter']";
			String titleSectionXPath = "//h5[@class='footer-newsletter__title']";
			String subscribeButtonXPath = "//a[@class='button button--primary']";
		}
		
		interface Registration
		{
			String registerNowAndOrderButtonXPath="//a[@class='button button--footer']";
		}
		
    }

    interface DashboardPage
    {
        String defaultUrl = "/dashboard";
 
    }
}
