package stepdefinition;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.EmailPage;
import pageobjects.LandingPage;
import pageobjects.PasswordPage;

public class StepDef {
	WebDriver driver;
	EmailPage emailPage;
	PasswordPage passwordPage;
	LandingPage landingPage;
	
	@Given("user opens the browser")
	public void user_opens_the_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    emailPage = new EmailPage(driver);
	    passwordPage = new PasswordPage(driver);
	    landingPage = new LandingPage(driver);
	}

	@Given("goes to the url {string}")
	public void goes_to_the_url(String url) throws InterruptedException{
	    driver.get(url);
	    Thread.sleep(3000);
	}
	
	@When("user clicks on the account and list link")
	public void user_clicks_on_the_account_and_list_link() throws InterruptedException {
		landingPage.clickOnAccountList();
		Thread.sleep(3000);
	}

	@When("user gives the email {string}")
	public void user_gives_the_email_and_password(String email){
	    emailPage.typeEmail(email);  //automates the typing of email
	}

	@When("user clicks the continue button")
	public void user_clicks_the_continue_button() throws InterruptedException{
		emailPage.clickContinueBtn();
	    Thread.sleep(3000);
	}

	@When("user gives the password {string}")
	public void user_gives_the_password(String password) {
		passwordPage.typePassword(password);
	}

	@Then("clicks the login button")
	public void clicks_the_login_button() {
		passwordPage.clickLoginBtn();
	}
	@Then("user verifies the login error message")
	public void user_verifies_the_login_error_message() {
	    String loginErrorText = passwordPage.getLoginErrorMessage();
	    if(loginErrorText.contains("There was a problem")) {
	    	Assert.assertTrue(true);
	    }
	    else {
	    	Assert.assertTrue(false);
	    }
	}

	@Then("user closes the browser")
	public void user_closes_the_browser() {
	    driver.close();
	}
	
	@After
	public void teardown(Scenario sc) {
		if(sc.isFailed()) {
			TakesScreenshot screenShot = (TakesScreenshot)driver;
			File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("target//screenshots//img.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
