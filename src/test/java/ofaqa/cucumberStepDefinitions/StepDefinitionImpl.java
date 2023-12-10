package ofaqa.cucumberStepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ofaqa.TestComponents.BaseTest;
import ofaqa.pageobjects.CartPage;
import ofaqa.pageobjects.CheckoutPage;
import ofaqa.pageobjects.ConfirmationPage;
import ofaqa.pageobjects.LandingPage;
import ofaqa.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CartPage cartPage;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on the e-commerce page")
	public void Landed_on_ecommerce_page() throws IOException {
		
		landingPage = launchApplication();
		
	}
	
	@Given("^Logged in with (.+) and (.+)$")
	public void Logged_in_with_credentials(String username, String password) {
		
		productCatalogue = landingPage.applicationLogin(username, password);
		
	}
	
	@When("^I add the (.+) to Cart$")
	public void Add_product_to_Cart(String productName) {
		
		productCatalogue.addProductToCart(productName);
		cartPage = productCatalogue.goToCartPage();
		
	}
	
	@And("^Checkout (.+) and submit the order$")
	public void Checkout_submit_order(String productName) {
		
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("Norway");
		confirmationPage = checkoutPage.submitOrder();
		
	}
	
	@Then("{string} message is displayed on the confirmation page")
	public void message_displayed_confirmation_page(String string) {
		
		String confirmation = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmation.equalsIgnoreCase(string));
		driver.close();
		
	}
	
	@Then("^\"([^\"]*)\" message is displayed$")
	public void something_is_displayed(String string) {
		
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.close();
		
	}

}
