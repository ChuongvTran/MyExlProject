package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='username']") WebElement UserName_Field; 
	@FindBy(how = How.XPATH, using = "//input[@id='password']") WebElement Password_Field;
	@FindBy(how = How.XPATH, using = "//button[@type='submit']") WebElement SignIn_Field;
	
	public void enterUserName(String userName) {
		UserName_Field.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		Password_Field.sendKeys(password);
	}
	
	public void clickSignInButton() {
		SignIn_Field.click();
	}

}
