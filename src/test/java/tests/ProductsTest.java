package tests;

import entity.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import steps.ProductsSteps;

public class ProductsTest extends BaseTest{
    //loginPage.openPage()
    //loginPage.login(username, password)
    //productPage.addToCart("entity.Product Name")
    //cartPage.openPage()
    //cartPage.getQuantity("entity.Product Name")
    //cartPage.getPrice("entity.Product Name")
    //Assertions

    @Test(description = "check products count on page")
    public void checkAmountOfProducts(){
        int amount = productsSteps.loginAndGetAmount(USERNAME, PASSWORD);
        Assert.assertEquals(amount, 6);
    }

    @Test(description = "add a product to cart and check if it was actually added")
    public void addToCartTest(){
        Product product = productsSteps.loginAndAddProductToCart(USERNAME, PASSWORD, SAUCE_LABS_BACKPACK);
        headerPage.openCartPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cartPage.getQuantity(), 1);
        softAssert.assertEquals(cartPage.getName(), product.getName());
        softAssert.assertEquals(cartPage.getPrice(), product.getPrice());
        softAssert.assertAll();
    }

    @Test(description = "check if content of button 'add to cart' changes after adding")
    public void checkContentOfAddToCartButton(){
        Product product = productsSteps.loginAndAddProductToCart(USERNAME, PASSWORD, SAUCE_LABS_BACKPACK);
        Assert.assertEquals(product.getButtonText(), "Remove");
    }
}
