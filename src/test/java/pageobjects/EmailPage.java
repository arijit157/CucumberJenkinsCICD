package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
	public WebDriver driver;
	
	public EmailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ap_email")
	public WebElement email;
	
	@FindBy(id="continue")
	public WebElement emailContinueBtn;
	
	public void typeEmail(String userEmail) {
		email.sendKeys(userEmail);
	}
	
	public void clickContinueBtn() {
		emailContinueBtn.click();
	}
}
