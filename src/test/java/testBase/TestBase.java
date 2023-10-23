package testBase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

    public class TestBase {

	public static WebDriver driver;
	public Logger logger;
	public FileReader file;
	public Properties prop;
	private String configpath = "C:\\Users\\Niraja\\Documents\\Neeraja\\Shared docs\\eclipse-workspace\\opencart\\src\\test\\resources\\config.properties";
		
		@BeforeClass(groups= {"Master", "Sanity", "Regression"})
		@Parameters("browser")
		public void setup(String br) throws IOException
		{
			file = new FileReader(configpath);
			prop = new Properties();
			prop.load(file);
			
			logger=LogManager.getLogger(this.getClass());
			
			if(br.equalsIgnoreCase("chrome"))
			{
				logger.info("Launching chrome browser...");
				
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
				driver = new ChromeDriver(options);	
			}
			else if(br.equalsIgnoreCase("edge"))
			{
				logger.info("Launching Edge browser...");
				EdgeOptions options = new EdgeOptions();
				options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
				driver=new EdgeDriver(options);
			}
			else if(br.equalsIgnoreCase("firefox"))
			{
				logger.info("Launching firefox browser...");
				driver=new FirefoxDriver();
			}
			else
			{
				driver=new SafariDriver();
			}
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			logger.info("Launching URL...");
			driver.get(prop.getProperty("URL"));   // local app URL
			//driver.get("https://demo.opencart.com/index.php");   // remote App URL
			
			logger.info("Maximizing the window...");
			driver.manage().window().maximize();
		}
		
		@AfterClass(groups= {"Master", "Sanity", "Regression"})
		public void tearDown()
		{
			driver.quit();
		}


		public String randomString()
		{
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		
		public String randomNumber()
		{
			String generatedString=RandomStringUtils.randomNumeric(10);
			return generatedString;
		}
		
		public String randomAlphaNumeric()
		{
			String str=RandomStringUtils.randomAlphabetic(3);
			String num=RandomStringUtils.randomNumeric(3);
			
			return (str+"@"+num);
		}
		
		public String captureScreen(String tname) throws IOException {

			Date dt = new Date();
			SimpleDateFormat sp = new SimpleDateFormat("yyyyMMddhhmmss");
			String timeStamp = sp.format(dt);
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
			return destination;

		}
	}

