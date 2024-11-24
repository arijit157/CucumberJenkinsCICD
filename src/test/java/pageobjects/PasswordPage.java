package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
	public WebDriver driver;
	
	public PasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ap_password")
	public WebElement password;
	
	@FindBy(id="signInSubmit")
	public WebElement loginBtn;
	
	@FindBy(xpath="(//div[@class='a-box-inner a-alert-container']/h4)[1]")
	public WebElement loginErrorMsg;
	
	public void typePassword(String userPassword) {
		password.sendKeys(userPassword);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public String getLoginErrorMessage() {
		return loginErrorMsg.getText();
	}
}
