package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FiscalCode {
	public static void main(String[] args) throws InterruptedException {

		// Set the path to chromedriver.exe based on your system configuration
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\shravyad\\\\eclipse-workspace\\\\CucumberJava\\\\src\\\\test\\\\resources\\\\drivers\\\\chromedriver.exe");

		// Create a new instance of ChromeDriver
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Navigate to the desired webpage
		driver.get("https://zip-codes.nonsolocap.it/codice-fiscale/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='ko']")).click();
//		WebElement Agree = driver.findElement(By.cssSelector("tagname#ko"));
//		jsExecutor.executeScript("arguments[0].click();", Agree);

		driver.findElement(By.xpath("//input[@id='cg']")).sendKeys("DDD");
		driver.findElement(By.xpath("//input[@id='nm']")).sendKeys("DDD");
		driver.findElement(By.xpath("//input[@id='lg']")).sendKeys("MILANO");

		driver.findElement(By.xpath("//input[@id='cb']"));
//		Select dropdownElement = new Select(dropdown);
//		dropdownElement.selectByIndex(0);
		// driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		// String FiscalCode =
		// driver.findElement(By.cssSelector("tagname#cf")).getText();

		// driver.quit();
	}

}
