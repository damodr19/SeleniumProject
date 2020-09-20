package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties config= new Properties();
	
	public static FileInputStream fis;
	
	
	@BeforeSuite
	public void setUp() throws IOException
	
	
	{
		
		if(driver==null)
		{
			fis = new FileInputStream(System.getProperty("user.dir"+"\\src\\test\\resources\\prpoperties\\config.properties"));
			config.load(fis);
		}
		
		if(config.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "");
			driver=new ChromeDriver();
		}
		
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void TearDown()
	{
		
	}

}
