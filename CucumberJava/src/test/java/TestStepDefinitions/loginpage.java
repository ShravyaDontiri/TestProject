package TestStepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginpage {

	WebDriver driver = new ChromeDriver();

	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		// String projectPath = System.getProperty("user.dir");
		// System.out.println("Projectpath is :" + projectPath);
// check
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shravyad\\eclipse-workspace\\CucumberJava\\src\\test\\resources\\drivers\\chromedriver.exe");

		driver.get("https://www.facebook.com/login/");
		Thread.sleep(2000);
		driver.manage().window().maximize();

	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@And("clicked on login")
	public void clicked_on_login() {
		driver.findElement(By.id("loginbutton")).click();
	}

	@Then("login is succesful")
	public void login_is_succesful() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
