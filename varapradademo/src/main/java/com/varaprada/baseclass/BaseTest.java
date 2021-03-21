package com.varaprada.baseclass;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	public static String projectPath = System.getProperty("user.dir");
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties p;
	public static Properties parentProp;
	public static Properties childProp;
	public static Properties orProp;
	
	
	public static void init() throws Exception
	{
		 fis = new FileInputStream(projectPath + "//data.properties" );
		 p = new Properties();
		 p.load(fis);
		 
		 fis = new FileInputStream(projectPath + "//or.properties");
			orProp = new Properties();
			orProp.load(fis);
			
		 

	}

	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath +"//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath +"//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	
	public static void navigateUrl(String url)
	{
		
		driver.navigate().to(p.getProperty(url));
	}
	
	public static void elementClick(String locatorKey) 
	{
		
		driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
	}

	
	public static void type(String locatorKey, String text) 
	{

		driver.findElement(By.name(orProp.getProperty(locatorKey))).sendKeys(text);
	}

	public static void selectItem(String locatorKey, String option)
	{
		
		driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
	}
	
}
