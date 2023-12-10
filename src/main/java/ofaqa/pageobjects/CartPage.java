package ofaqa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ofaqa.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	@FindBy(css = ".totalRow button")
	WebElement checkout;
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cart;

	public CartPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public Boolean verifyProductDisplay(String productName) {
		
		Boolean match = cart.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	public CheckoutPage goToCheckout() {
		
		checkout.click();
		return new CheckoutPage(driver);
		
	}

}
