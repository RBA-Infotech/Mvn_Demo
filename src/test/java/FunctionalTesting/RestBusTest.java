package FunctionalTesting;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class RestBusTest {

	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// To Launch the URL
		driver.get("https://www.redbus.in/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		//driver.quit();
	}
	
	@Test
	public void validateRedbusWebsite() {

		String expResult = "Bus Ticket Booking Online made Easy, Secure with Top Bus Operators - redBus";
		String actResult = driver.getTitle();

		System.out.println("The title of Redbus website is: " + actResult);
		Assert.assertEquals(actResult, expResult);
		driver.close();
		
	}
}
