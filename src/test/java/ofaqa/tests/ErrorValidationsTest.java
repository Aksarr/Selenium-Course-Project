package ofaqa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ofaqa.TestComponents.BaseTest;
import ofaqa.pageobjects.CartPage;
import ofaqa.pageobjects.ProductCatalogue;
import ofaqa.TestComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws IOException {

		landingPage.applicationLogin("dummy.account@email.com", "11Qazxsw21");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void productErrorValidation() throws IOException {

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.applicationLogin("dummy.account@email.com", "Qazxsw21");
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}

}
