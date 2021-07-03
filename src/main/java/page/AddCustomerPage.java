package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;
	String enteredName;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(), ' Contacts ')]")
	WebElement Contacts_Field;
	@FindBy(how = How.XPATH, using = "//input[@name='account']")
	WebElement Full_Name_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement Email_Field;
	@FindBy(how = How.XPATH, using = "//select[@name='cid']")
	WebElement Company_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement Phone_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement Address_Field;
	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	WebElement City_Field;
	@FindBy(how = How.XPATH, using = "//input[@name='state']")
	WebElement State_Field;
	@FindBy(how = How.XPATH, using = "//input[@name='zip']")
	WebElement Zip_Field;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement Country_Field;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement Save_Button_On_Add_Contact_Field;
	@FindBy(how = How.XPATH, using = "//a[@id='summary']")
	WebElement Summary_Button_On_Summary_Page;
	@FindBy(how = How.XPATH, using = "//button[@data-bb-handler='confirm']")
	WebElement Delete_Button_Field;


	public void verifyContactsField() {
		Assert.assertEquals(Contacts_Field.getText(), "Contacts", "Wrong Page");
	}

	public void enterFullName(String fullname) {
		enteredName = fullname + generateNumber(999);
		Full_Name_Field.sendKeys(enteredName);
	}

	public void enterEmail(String email) {
		Email_Field.sendKeys(generateNumber(999) + email);
	}

	public void enterCompany(String company) {
		selectDropDown(Company_Field, company);
	}

	public void enterPhone(String phone) {
		Phone_Field.sendKeys(phone + generateNumber(999));
	}

	public void enterAddress(String Address) {
		Address_Field.sendKeys(Address);
	}

	public void enterCity(String City) {
		City_Field.sendKeys(City);
	}

	public void enterState(String State) {
		State_Field.sendKeys(State);
	}

	public void enterZip(String Zip) {
		Zip_Field.sendKeys(Zip);
	}

	public void enterCountry(String Country) {
		selectDropDown(Country_Field, Country);
	}

	public void clickSaveButtonOnAddContact() {
		Save_Button_On_Add_Contact_Field.click();
	}

	public void verifySummaryPage() {
		waitForElement(driver, 5, Summary_Button_On_Summary_Page);
		Assert.assertEquals(Summary_Button_On_Summary_Page.getText(), "Summary", "wrong page");
	}
	
	public void verifyFullNameField() {
		waitForElement(driver, 5, Full_Name_Field);
		Assert.assertEquals(Full_Name_Field, Full_Name_Field);
	}


	public void verifyEnteredNameAndDelete() {
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";

		for (int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			
			/*
			 * System.out.println(name); Assert.assertEquals(name, enteredName,"WrongPage");
			 * break ;
			 */
			 

			if (name.contains(enteredName)) {
				System.out.println("entered name exist");
				driver.findElement(By.xpath(before_xpath + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
			}
		}

	}

	// tbody/tr[1]/td[3]
	// tbody/tr[2]/td[3]
	// tbody/tr[3]/td[3]
	// tbody/tr[i]/td[3]
	// tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
	// tbody/tr[i]/td[3]/following-sibling::td[4]/a[2]
	
	public void Click_Delete_Button() {
		Delete_Button_Field.click();
		
	}
		

}
