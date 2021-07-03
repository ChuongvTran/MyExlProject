package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboradPage {
	
WebDriver driver;
	
	public DashboradPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(), ' Dashboard ')]") WebElement DashBborad_Header_Field; 
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Customers')]") WebElement Customers_Field; 
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Customer')]") WebElement Add_Customers_Field;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'List Customers')]") WebElement List_Customers_Field;
	
	public void verifyDashboradPage() {
		Assert.assertEquals(DashBborad_Header_Field.getText(), "Dashboard", "Wrong Page");
		
	}

	public void clickCustomersButton() {
		Customers_Field.click();
	}
	
	public void clickAddCustomersButton() {
		Add_Customers_Field.click();
	}
	
	public void clickList_Customers_Field() {
		List_Customers_Field.click();
	}
	
}

