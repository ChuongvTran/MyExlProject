package test;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboradPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\testdata.xlsx");
	String userName = exlread.getCellData("LoginData", "UserName", 2);
	String password = exlread.getCellData("LoginData", "Password", 2);
	String fullName = exlread.getCellData("AddCustomers", "FullName", 2);
	String CompanyName = exlread.getCellData("AddCustomers", "CompanyName", 2);
	String Email = exlread.getCellData("AddCustomers", "Email", 2);
	String Phone = exlread.getCellData("AddCustomers", "Phone", 2);
	String Address = exlread.getCellData("AddCustomers", "Address", 2);
	String City = exlread.getCellData("AddCustomers", "City", 2);
	String Country = exlread.getCellData("AddCustomers", "Country", 2);
	String State = exlread.getCellData("AddCustomers", "State", 2);
	String ZIP = exlread.getCellData("AddCustomers", "ZIP", 2);
	
	@Test
	public void validUserShouldBeAbleToCreateCustomer() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterUserName(userName);
		loginpage.enterPassword(password);
		loginpage.clickSignInButton();
		
		DashboradPage dashboradPage = PageFactory.initElements(driver, DashboradPage.class);
		dashboradPage.verifyDashboradPage();

		dashboradPage.clickCustomersButton();
		dashboradPage.clickAddCustomersButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyContactsField();
		
		addCustomerPage.verifyFullNameField();
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterEmail(Email);
		addCustomerPage.enterCompany(CompanyName);
		addCustomerPage.enterPhone(Phone);
		addCustomerPage.enterAddress(Address);
		addCustomerPage.enterCity(City);
		addCustomerPage.enterState(State);
		addCustomerPage.enterZip(ZIP);
		addCustomerPage.enterCountry(Country);
		addCustomerPage.clickSaveButtonOnAddContact();
		addCustomerPage.verifySummaryPage();
		

		dashboradPage.clickList_Customers_Field();
		
		
		addCustomerPage.verifyEnteredNameAndDelete();
		
		addCustomerPage.Click_Delete_Button();
		
		
/*		String alertMsg = driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();*/

	}
}
