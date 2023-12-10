package ofaqa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ofaqa.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath = "(//button[contains(@class, 'ta-item')])[1]")
	WebElement selectCountry;
	
	@FindBy(css = ".action__submit")
	WebElement submitButton;
	
	By countryResults = By.cssSelector(".ta-results");
	
	public CheckoutPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void selectCountry(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(countryResults);
		selectCountry.click();
		
	}
	
	public ConfirmationPage submitOrder() {
		
		submitButton.click();
		return new ConfirmationPage(driver);
		
	}

}
