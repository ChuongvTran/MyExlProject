package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboradPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\testdata.xlsx");
	String userName = exlread.getCellData("LoginData", "UserName", 2);
	String password = exlread.getCellData("LoginData", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterUserName(userName);
		loginpage.enterPassword(password);
		loginpage.clickSignInButton();
		
		DashboradPage dashBorad = PageFactory.initElements(driver, DashboradPage.class);
		
//		BrowserFactory.tearDown();
		
	}
}
