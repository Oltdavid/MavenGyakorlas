package gyak.mavengyakorlas;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class mavenTest {
	WebDriver driver;
	String url;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		url = "https://learn.letskodeit.com/p/practice";
		report = new ExtentReports("C:\\Udemy\\workspace\\mavengyakorlas\\test-output\\sajatreport\\dave.html");
		test = report.startTest("Próba");
		test.log(LogStatus.INFO, "Browser started..");
		test.log(LogStatus.PASS, "passed");

		driver = new ChromeDriver();
		driver.get(url);
		test.log(LogStatus.INFO, "Browser open the website..");
		test.log(LogStatus.PASS, "passed");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser is maximazed");
		test.log(LogStatus.PASS, "passed");

	}

	@Test
	public void mavenTest() throws InterruptedException {

		WebElement radioButtonHonda = driver.findElement(By.cssSelector("#radio-btn-example [value='honda']"));
		radioButtonHonda.click();
		test.log(LogStatus.INFO, "click Honda");
		test.log(LogStatus.PASS, "Honda clicked");
		Thread.sleep(1000);

		WebElement radioButtonBMW = driver.findElement(By.xpath("/html//input[@id='bmwradio']"));
		radioButtonBMW.click();
		test.log(LogStatus.INFO, "click BMW");
		test.log(LogStatus.PASS, "BMW clicked");
		Thread.sleep(1000);

		WebElement radioButtonBenz = driver.findElement(By.cssSelector("#radio-btn-example [value='benz']"));
		radioButtonBenz.click();
		test.log(LogStatus.INFO, "click Benz");
		test.log(LogStatus.PASS, "Benz clicked");
		Thread.sleep(1000);

		WebElement welcometext = null;

		try {
			welcometext = driver.findElement(By.cssSelector("h1"));

		} catch (Exception e) {
			test.log(LogStatus.ERROR, "Nincs meg az elem");
		}
		Assert.assertTrue(welcometext != null);
		test.log(LogStatus.PASS, "Nincs meg az elem");

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(1000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
