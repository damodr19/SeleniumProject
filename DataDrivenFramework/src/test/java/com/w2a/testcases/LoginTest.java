package com.w2a.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;





















import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.Validate;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class LoginTest {
	
	
 ExtentTest test;
	 ExtentReports extent;
	 ExtentHtmlReporter htmlReporter;
	
	static WebDriver driver =null;
	
	static int targetDay = 0,
			   targetMonth = 0,
			   targetYear = 0;
	
	static int currentDay = 0,
			   currentMonth = 0,
			   currentYear = 0;
	
	static int jumpMonthsBy=0;
	
	static boolean increment = true;
	
	
	 public static final String USERNAME = "dbhatt_125";
	    public static final String ACCESS_KEY = "8c53-4d48-ad4d-8557cbe9e6c2";
	    public static final String URL = "https://" + USERNAME  + ":" + "528af8ec-50eb-4699-8f49-9cb13ffc92a4" + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	    
	    
	    public static void getCurrentDateMonthAndYear(){
			
			Calendar cal = Calendar.getInstance();
			
			currentDay = cal.get(Calendar.DAY_OF_MONTH);
			currentMonth = cal.get(Calendar.MONTH)+1;
			currentYear = cal.get(Calendar.YEAR);
			
			
			
		}
		
		
		
	    @DataProvider(name="dataprovider")
	    public static Object[][] credentials()
	    
	    {
	    	
	    	return new Object[][]{{"india"}};
	    }
	    
	    
	    
	    
	    public static void GetTargetDateMonthAndYear(String dateString)
		{
			
			
			int firstIndex = dateString.indexOf("/");
			int lastIndex = dateString.lastIndexOf("/");
			
			String day = dateString.substring(0, firstIndex);
			targetDay = Integer.parseInt(day);
			
			
			String month = dateString.substring(firstIndex+1, lastIndex);
			targetMonth = Integer.parseInt(month);
			
			
			String year = dateString.substring(lastIndex+1, dateString.length());
			targetYear = Integer.parseInt(year);
			
		}
		
		
		public static void CalculateHowManyMonthsToJump(){
			
			if((targetMonth-currentMonth)>0){
				
				jumpMonthsBy = (targetMonth-currentMonth);
			}else{
				
				jumpMonthsBy = (currentMonth-targetMonth);
				increment = false;
			}
			
			
		}

	
	
	@BeforeClass
	
	public static void startTest()
	
	{
		
		//report = new ExtentReports(System.getProperty("user.dir")+ "\\ExtentReportResults.html");
	}
	
	@BeforeMethod
	
	public void setUp()
	{
	   WebDriverManager.chromedriver().setup();	
		
		htmlReporter = new ExtentHtmlReporter("./reports/extent.html");

		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("W2A Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Automation Tester", "Rahul Arora");
		extent.setSystemInfo("Orgainzation", "Way2Automation");
		extent.setSystemInfo("Build No", "W2A-1234");


		
	}
	
	
	
	
	
	//@Test
	public void loginTest()
	{
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://in.yahoo.com/?p=us");
		
		WebElement searchInput =driver.findElement(By.id("header-search-input"));
		searchInput.sendKeys("hello");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<WebElement> values =driver.findElements(By.xpath("//div[@type='normal']"));
		
		for (WebElement value: values) {
			
			System.out.println(value.getText());
			
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		
		driver.get("https://www.makemytrip.com");
		
		
	 List<WebElement> links = driver.findElements(By.tagName("a"));
	 System.out.println(links.size());
	 
	 
	 
		
	

	}
	
	//@Test
	public void checkRadio()
	{
		
		
			
			WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://echoecho.com/htmlforms10.htm");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.manage().window().maximize();
	List<WebElement> radiobutton =driver.findElements(By.xpath("//input[@name='group1']"));
	
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	//js.executeScript("arguments[0].scrollIntoView();", radiobutton);
	
	for (WebElement webElement : radiobutton) {
		
		try {
			System.out.println("Check Box value:"+ 	webElement.getAttribute("value"));
		
			webElement.click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	driver.close();
	
	
	
	}
	
	
	public void captureScrenShot(WebDriver driver) throws IOException
	{
		Date d = new Date();
		
		String fileName = d.toString().replaceAll(":", "_");
		
		File screenShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenShot, new File(".//Screenshot//"+ fileName+".jpg"));
		
		
	}
	
	public void captureScrenShotSpecificElement(WebDriver driver,WebElement ele)
	{
		
		try
		{
			
		
		Date d = new Date();
		
		String fileName = d.toString().replaceAll(":", "_");
		
		File screenShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		BufferedImage fullImg=ImageIO.read(screenShot);
		Point point =ele.getLocation();
		System.out.println(point);
		
		int elementWidth =ele.getSize().getWidth();
		int elementHeight =ele.getSize().getHeight();
		System.out.println(elementWidth);
		System.out.println(elementHeight);
		
		BufferedImage subimage =fullImg.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight);
		ImageIO.write( subimage , "jpg", screenShot);
		FileUtils.copyFile(screenShot, new File(".//ScreenshotSpecefic//"+ fileName+".jpg"));
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	public void capture(WebDriver driver,WebElement ele)
	{
		
		try
		{
			
		
		Date d = new Date();
		
		String fileName = d.toString().replaceAll(":", "_");
		
		File screenShot =((TakesScreenshot)ele).getScreenshotAs(OutputType.FILE);
		
		
		FileUtils.copyFile(screenShot, new File(".//ScreenshotSpecefic//"+ fileName+".jpg"));
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	public void captureWithAshot(WebDriver driver) throws IOException
	
	
	{
		
		Date d = new Date();

		String fileName = d.toString().replaceAll(":", "_");
		Screenshot screenShot = new AShot().shootingStrategy(
				ShootingStrategies.viewportPasting(2000))
				.takeScreenshot(driver);

		ImageIO.write(screenShot.getImage(), "jpg", new File(
				".//ScreenshotSpecefic//" + fileName + ".jpg"));
		
		
		
		
	}

	
	
	
	
	
	//@Test
	
	public void checkFooterLinks() throws IOException
	{
		
		
			
	
	driver = new ChromeDriver();
	
	driver.get("https://www.hollisterco.com/shop/wd");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	try 
	{
	driver.manage().window().maximize();
	
	
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='submit']")));
	WebElement logo =driver.findElement(By.xpath("//button[@name='submit']"));
	captureScrenShotSpecificElement(driver,logo);
	Actions action = new Actions(driver);
	//action.sendKeys(Keys.CONTROL.END).perform();;
	WebElement footerElement =driver.findElement(By.cssSelector(".footer__info-links.grid-col.grid-col-2 ul ul"));
	
	
	
	
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	//js.executeScript("arguments[0].scrollIntoView();", radiobutton);
	List<WebElement> footerLinks = footerElement.findElements(By.tagName("a"));
	
	System.out.println("Links is:" + footerLinks.size());
	
	
	
	captureScrenShot(driver);
	
	driver.close();
	
	
	}
	
	catch(Exception e)
	{
		
		
		e.printStackTrace();
		driver.close();
	}
	

	}
	
	
	
	
	
	//@Test
	public void testScreenShotWithAshot() throws IOException
	{
		
		
		
		test = extent.createTest("Login Test");

		DesiredCapabilities caps =DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "latest");
		this.driver=(new RemoteWebDriver(new URL(URL),caps));
		driver.get("http://www.way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		captureWithAshot(driver);
		
		
		
	}
	
	
	//@Test
	
	public void testGrid() throws MalformedURLException
	{
		
		DesiredCapabilities  caps = DesiredCapabilities.chrome();
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.WINDOWS);
		
		this.driver= new RemoteWebDriver(new  URL("http://192.168.0.104:5555/wd/hub"), caps);
		driver.get("http://www.way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			captureWithAshot(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//@Test
	public void testCalander()
	{
		driver = new ChromeDriver();
		
		driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
        String dateToSet= "25/11/2020";
		
		//get current date
		getCurrentDateMonthAndYear();
		System.out.println(currentDay+"   "+currentMonth+"   "+currentYear);
		
		//get target date
		GetTargetDateMonthAndYear(dateToSet);
		System.out.println(targetDay+"   "+targetMonth+"   "+targetYear);
		
		
		//Get Jump month
		CalculateHowManyMonthsToJump();
		System.out.println(jumpMonthsBy);
		System.out.println(increment);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='k-icon k-i-calendar']")));

WebElement datepick =driver.findElement(By.xpath("//span[@class='k-icon k-i-calendar']"));
datepick.click();


wait = new WebDriverWait(driver, 30);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='k-link k-nav-next']")));

WebElement dateincrementlink=driver.findElement(By.xpath("//a[@class='k-link k-nav-next']"));



for(int i=0; i<jumpMonthsBy;i++){
	
	System.out.println("Next Times" + i);
	
	if(increment){
wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.elementToBeClickable(dateincrementlink));
		
		dateincrementlink.click();
		System.out.println("Wating for Next");
		wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'k-link k-nav-next')]")));
		
		dateincrementlink=driver.findElement(By.xpath("//a[contains(@class,'k-link k-nav-next')]"));
		
		
	}
	
	
}
driver.findElement(By.linkText(Integer.toString(targetDay))).click();
	}
	@AfterTest
	
	public void testClose()
	{
		extent.flush();

		
		//driver.close();
	}
	
	//@Test(dataProvider="dataprovider")
	public void testGoogle(String user) throws InterruptedException
	{
		driver = new ChromeDriver();
		
		int count =0;
	
		//driver.navigate().to("https://www.google.com/");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		String Title = driver.getTitle();
		System.out.println(Title);
		Thread.sleep(2000);
		WebElement search =driver.findElement(By.xpath("//input[@name='q']"));
		
		search.sendKeys( user);
		search.sendKeys(Keys.ENTER);
		

		Thread.sleep(2000);
		
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='rso']/div[@class='g']/div[@class='rc']/div[@class='r']/a"));
		//driver.manage().refresh();
		
		for(WebElement link :links)
			
			
		{
			
			count =count+1;
			
		if(count==4)
		{
			//JavascriptExecutor js = (JavascriptExecutor)driver;
			//js.executeScript("arguments[0].scrollIntoView();", link);
			
			
			//js.executeScript("arguments[0].setAttribute('style','border: solid 2px red');",link);
			
			//Thread.sleep(5000);
			
			//js.executeScript("arguments[0].click();", link);
			Thread.sleep(2000);
			
			link.click();
			break;
		}
		
		
		}
		
          Thread.sleep(2000);
		
		Title = driver.getTitle();
		
		System.out.println(Title);
	}
	
	
	//@Test
	
	public void testNotification()
	{
		
		
		ChromeOptions options = new ChromeOptions();
	
		
		
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		
	driver.get("https://www.redbus.in");
	}
	
//@Test
	
	public void testNotification2()
	{
		
		
		ChromeOptions options = new ChromeOptions();
	
		
		
		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		
	driver.get("https://www.google.com");
	}
	
	//@Test
	
	public void testAssert()
	{
		Assert.fail("I m fail");
	}
	
	
	//@Test
	public void TestExcelWrite() throws Exception
	{
		
		XSSFWorkbook workBook = new XSSFWorkbook();
		
		XSSFSheet sheet =workBook.createSheet("LoginTest");
		XSSFRow row =sheet.createRow(0);
		XSSFCell cell =row.createCell(0);
		XSSFCell cell1 =row.createCell(1);
		cell.setCellValue("UserName");
		cell1.setCellValue("Password");
		
		File f = new File(System.getProperty("user.dir")+"/testdata/testdata.xlsx");
		
		FileOutputStream fos = new FileOutputStream(f);
		
		workBook.write(fos);
		fos.close();
		
		
		
		
		
		
		
	}
	
	

	
	public void TestExcelRead() throws Exception
	{
		
		XSSFWorkbook workBook = new XSSFWorkbook();
		
		XSSFSheet sheet =workBook.createSheet("LoginTest");
		XSSFRow row =sheet.createRow(0);
		XSSFCell cell =row.createCell(0);
		XSSFCell cell1 =row.createCell(1);
		cell.setCellValue("UserName");
		cell1.setCellValue("Password");
		
		File f = new File(System.getProperty("user.dir")+"/testdata/testdata.xlsx");
		
		FileOutputStream fos = new FileOutputStream(f);
		
		workBook.write(fos);
		fos.close();
		
		
		
		
		
		
		
	}
//	@Test
	public void readTestData() throws Exception
	{
		File f = new File(System.getProperty("user.dir")+"/testdata/testdata.xlsx");
		FileInputStream fis =new FileInputStream(f);
		XSSFWorkbook workBook  =new XSSFWorkbook(fis);
		XSSFSheet sheet =workBook.getSheetAt(0);
		XSSFRow row =sheet.getRow(0);
		XSSFCell cell =row.getCell(0);
		System.out.println(cell.getStringCellValue());
		
		
		for(Row rows :sheet)
		{
			
			for(Cell cells:rows)
			{
				switch (cells.getCellType()) {
				case  Cell.CELL_TYPE_STRING:
					
					System.out.print(cells.getStringCellValue() + "\t");
					
					break;
					
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cells.getNumericCellValue() + "\t");
					break;
					
				case Cell.CELL_TYPE_BLANK:
					System.out.print("blank" + "\t");
					break;

				default:
					break;
				}
			}
			
		}
		
	}
	
	@Test
	public void readTestDataAll() throws Exception
	{
		File f = new File(System.getProperty("user.dir")+"/testdata/testdata.xlsx");
		FileInputStream fis =new FileInputStream(f);
		XSSFWorkbook workBook  =new XSSFWorkbook(fis);
		XSSFSheet sheet =workBook.getSheetAt(0);
		int rowc =sheet.getLastRowNum();
		System.out.println(rowc);
		
		for (int i=0;i<=rowc;i++)
		{
			System.out.println();
			int colCount =sheet.getRow(i).getLastCellNum();
			
			
			for(int j =0;j<colCount;j++)
			{
				
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+ " ");
				
			}
			
		}
		
	}
	
	
	
	//@Test
	
	public void readTestdata() throws Exception
	{
		
	
	
	
	FileInputStream fis = new FileInputStream("");
	
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	
	int sheets = wb.getNumberOfSheets();
	for(int i=0;i<sheets;i++)
	{
		if(wb.getSheetName(i).equalsIgnoreCase("TestData"))
		{
			XSSFSheet sheet=wb.getSheetAt(i);
			Iterator<Row> rows =sheet.iterator();
			
			Row FirstRow=rows.next();
			Iterator<Cell>cells =FirstRow.cellIterator();
			int k=0;
			int coloumn=0;
			while(cells.hasNext())
			{
				Cell value=cells.next();
				
				if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
				{
					coloumn=k;
				}
				k++;
			}
			 while(rows.hasNext())
			 {
				 Row  r = rows.next();
				 
				 if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("TestCaseName"))
				 {
					 
				 }
			 }
			
			
		}
		}
		
		
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	
	}

