package com.inetbanking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilies.ReadConfig;

public class BaseClass {
	
	
	ReadConfig readCon = new ReadConfig();

	public String baseURL = readCon.getapplicationUrl();
	public String username = readCon.getUsername();
	public String pasword = readCon.getPwd(); 
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
	
	   logger = Logger.getLogger("ebanking");
	   PropertyConfigurator.configureAndWatch("Log4j.properties");
	
    if(br.equals("chrome")) {
    	System.setProperty("webdriver.chrome.driver", readCon.getChromePath());
	    driver = new ChromeDriver();
    }
    else if (br.equals("firefox")) {
    	System.setProperty("webdriver.gecko.driver", readCon.getFirefoxPath());
	    driver = new FirefoxDriver();
    }
    else if (br.equals("IE")) {
    	System.setProperty("webdriver.ie.driver", readCon.getIEPath());
	    driver = new InternetExplorerDriver();
    }
    driver.get(baseURL);
	
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
