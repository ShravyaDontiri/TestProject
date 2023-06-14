package TestStepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.VariableUtils;

public class Telesaleswln {

	WebDriver driver = null;
	WebDriverWait wait;
	VariableUtils VariableUtils = new VariableUtils();

	@Given("user login to telesales channel")
	public void user_login_to_telesales_channel() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shravyad\\eclipse-workspace\\CucumberJava\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.get("http://illnqw1352:25050/retail/retail-login");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("TELESALE88");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.xpath("//*[@type='button']")).click();

		WebElement newCustomerElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='NUOVO CLIENTE']")));
		String newCustomerText = newCustomerElement.getText();
		System.out.println("PageText is: " + newCustomerText);

//		Thread.sleep(2000);
//		String NewCustomer = driver.findElement(By.xpath("//span[text()='NUOVO CLIENTE']")).getText();
//		System.out.println("PageText is:" + NewCustomer);

	}

	@And("enter address details")
	public void enter_address_details() throws InterruptedException {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Thread.sleep(3000);

		WebElement nuovoCliente = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='NUOVO CLIENTE']")));
		nuovoCliente.click();

		WebElement closeIcon = driver.findElement(By.xpath("//div[@class='close-icon']"));
		wait.until(ExpectedConditions.elementToBeClickable(closeIcon));
		jsExecutor.executeScript("arguments[0].click();", closeIcon);

		// wait.until(ExpectedConditions.jsReturnsValue("return document.readyState ===
		// 'complete';"));

		WebElement offerte = driver
				.findElement(By.xpath("//a[@data-automation-id='link_headerretaill9module_offerte-fibra-e-ADSL']"));
		wait.until(ExpectedConditions.elementToBeClickable(offerte));
		jsExecutor.executeScript("arguments[0].click();", offerte);
		// offerte.click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys("Milano");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span.ds-search__highlight")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='searchAutoComplete'])[2]")).sendKeys("Via Logrentigio");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Via Logrentigio']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='address.streetNumber']")).sendKeys("240");

		// jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		WebElement element1 = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
		jsExecutor.executeScript("arguments[0].click();", element1);

		// driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
		Thread.sleep(25000);
		// driver.quit();

	}

	@And("select offer and add to cart")
	public void select_offer_and_add_to_cart() throws InterruptedException {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		WebElement setOffer = driver.findElement(By.xpath("//div[@class='autocomplete-container ds-search']/input[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(setOffer));
		setOffer.sendKeys("BETA Internet Unlimited");

		driver.findElement(By.xpath("//input[@type='button']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//span[text()='Continua'])[1]")).click();
		Thread.sleep(23000);
		WebElement element2 = driver
				.findElement(By.xpath("//button[@data-automation-id='activateOnlineButton_totalsbarretaill9module']"));
		jsExecutor.executeScript("arguments[0].click();", element2);
		Thread.sleep(25000);
		WebElement element3 = driver
				.findElement(By.xpath("//button[@data-automation-id='checkoutButton_shoppingcartretaill9module']"));
		jsExecutor.executeScript("arguments[0].click();", element3);
		Thread.sleep(25000);

		// driver.findElement(By.xpath("//button[@data-automation-id='checkoutButton_shoppingcartretaill9module']"));

	}

	@And("^user enters (.*),(.*),(.*) and (.*)$")
	public void user_enters_firstname_lastname_fiscalcode_and_email(String firstName, String lastName,
			String fiscalCode, String email) throws InterruptedException {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		System.out.println("First Name: " + firstName);

		int randomNumber = VariableUtils.getRandomNumber();
		driver.findElement(By.xpath("//input[@name='volaMsisdn']")).sendKeys(String.valueOf(randomNumber));
		driver.findElement(By.xpath("//span[text()='Continua']")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@name='owningIndividual.firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='owningIndividual.lastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='owningIndividual.fiscalCode']")).sendKeys(fiscalCode);

		WebElement nation = driver.findElement(By.xpath("//input[@name='owningIndividual.nation']"));
		nation.sendKeys("Italia");
		nation.sendKeys(Keys.ARROW_DOWN);
		nation.sendKeys(Keys.RETURN);

		WebElement ID = driver
				.findElement(By.xpath("//input[@name='owningIndividual.identification.identificationType']"));
		ID.sendKeys("Passaporto");
		ID.sendKeys(Keys.ARROW_DOWN);
		ID.sendKeys(Keys.RETURN);

		int passport = VariableUtils.getPassport();
		driver.findElement(By.xpath("//input[@name='owningIndividual.identification.identificationNumber']"))
				.sendKeys("VFIT" + passport);

		WebElement nationality = driver
				.findElement(By.xpath("//input[@name='owningIndividual.identification.nationality']"));
		nationality.sendKeys("Italia");
		nationality.sendKeys(Keys.ARROW_DOWN);
		nationality.sendKeys(Keys.RETURN);

		WebElement date = driver.findElement(By.xpath("(//input[@type='text'])[8]"));
		date.sendKeys("13/06/2025");
		date.sendKeys(Keys.RETURN);
		// Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='owningIndividual.email.emailAddress']")).sendKeys(email);
		int contactNumber = VariableUtils.getContactNumber();
		driver.findElement(By.xpath("//input[@name='owningIndividual.phone.phoneNumber']"))
				.sendKeys(String.valueOf("39" + contactNumber));
		driver.findElement(By.xpath("//button[@type='submit']/span")).click();
		Thread.sleep(30000);
		// continue to telephone button
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
		WebElement continue1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='continua']")));
		continue1.click();
		// Thread.sleep(30000);
		// continue to consegna
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
		WebElement continue2 = wait.until(ExpectedConditions.elementToBeClickable(By.className("mb30")));
		jsExecutor.executeScript("arguments[0].click();", continue2);
		// driver.findElement(By.xpath("//span[text()='continua']")).click();
		Thread.sleep(30000);
		// continue to consensi
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
		WebElement radioButton1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='happy_full--yes_0']")));
		radioButton1.click();
		WebElement radioButton2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='yes_0']")));
		radioButton2.click();
		// driver.findElement(By.xpath("(//input[@value='Yes'])[6]")).click();
		driver.findElement(By.xpath("//span[text()='continua']")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//button[text()='Salta questo passaggio']")).click();

		// sintesi contrattuale button
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
		WebElement contractSummary = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sintesi contrattuale']")));
		contractSummary.click();
		WebElement checkBox = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='agreeTerms']/div/span[2]")));
		jsExecutor.executeScript("arguments[0].click();", checkBox);

//		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileHandler.copy(screenShot, new File(
//					"C:\Users\shravyad\git\TestProject\CucumberJava\\src\\test\\resources\\screenshots.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// driver.findElement(By.xpath("//span[text()='Conferma']")).click();
	}

	@When("user completes the payment")
	public void user_completes_the_payment() {
		System.out.println("Pending");

	}

	@And("click on submit order button")
	public void click_on_submit_order_button() {
		System.out.println("Pending");

	}

	@Then("verify that order is submitted")
	public void verify_that_order_is_submitted() {
		System.out.println("Pending");

	}
}
