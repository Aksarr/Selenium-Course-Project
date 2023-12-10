package ofaqa.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ofaqa.TestComponents.BaseTest;
import ofaqa.pageobjects.CartPage;
import ofaqa.pageobjects.CheckoutPage;
import ofaqa.pageobjects.ConfirmationPage;
import ofaqa.pageobjects.OrderPage;
import ofaqa.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException {

		ProductCatalogue productCatalogue = landingPage.applicationLogin(input.get("email"), input.get("password"));
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("Norway");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmation = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmation.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistoryTest() {

		ProductCatalogue productCatalogue = landingPage.applicationLogin("dummy.account@email.com", "Qazxsw21");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Boolean match = orderPage.verifyOrderDisplay(productName);
		Assert.assertTrue(match);

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\ofaqa\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
		

	}

}
