package ofaqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ofaqa.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submitButton;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public ProductCatalogue applicationLogin(String email, String password) {

		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submitButton.click();
		return new ProductCatalogue(driver);
		

	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client");

	}
	
	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}

}
