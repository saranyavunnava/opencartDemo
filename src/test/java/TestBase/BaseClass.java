package TestBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.ExtentReportManager;

public class BaseClass {
	//public static WebDriver driver;
	public static Logger logger;
	public Properties prop;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
        System.out.println("Browser setup by Thread : " + Thread.currentThread().getId() + " and Driver reference is : "
                + getDriver());
    }
	
	// Loading Properties file
	@BeforeClass(groups = { "smoke", "sanity", "regression", "test" })
	@Parameters({ "browser", "os" })
	public void setup(String browser, String os) throws IOException {
		prop = new Properties();
		prop.load(new FileReader("./src//test//resources/config.properties"));
		switch (browser.toLowerCase()) {
		case "chrome":
			// driver = new ChromeDriver();
			setDriver(new ChromeDriver());
			break;
		case "edge":
			// driver = new EdgeDriver();
			setDriver(new EdgeDriver());
			break;
		default:
			throw new IllegalArgumentException("Invalid browser name..." + browser);
		}
		WebDriver driver=getDriver();

		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("appURL"));
		System.out.println(prop.getProperty("appURL"));
		driver.manage().window().maximize();
		logger = LogManager.getLogger(this.getClass());
	}

	public String generateString() {
		String generatedString = RandomStringUtils.randomAlphanumeric(5);
		System.out.println(generatedString);
		return generatedString;
	}

	public String generateNumber() {
		return RandomStringUtils.randomNumeric(10);
	}

	public String screenShot(String name) {

		String path = System.getProperty("user.dir") + "\\Screenshots\\" + name + ".png";
		File dest = new File(path);
		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		src.renameTo(dest);
		return path;
	}

	
	@AfterClass(groups = { "sanity", "smoke", "regression","test" })
	 public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		      // WebDriver driver = getDriver();
		        if (driver != null) {
		            driver.get().quit();
		        }
		        Thread.sleep(5000);
		       driver.remove();}}