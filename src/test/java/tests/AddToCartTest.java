package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    @Test
    public void TestAddToCart(){
       var CartTest= homePage.clickAddToCartButton();
        Assert.assertEquals(CartTest.getCartPageText(),"Cart","Not match");
    }



}
