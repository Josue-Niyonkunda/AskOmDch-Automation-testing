package tests.update;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteTest extends BaseTest {

    @Test
    public void deleteProduct(){

        Assert.assertEquals(homePage.clickAddToCartButton().getDeleteMessage(),"“Blue Shoes” removed. Undo?","Not match");
        // Assert.assertTrue(homePage.clickAddToCartButton().getDeleteMessage().contains("removed."),"Not match");
    }
}
