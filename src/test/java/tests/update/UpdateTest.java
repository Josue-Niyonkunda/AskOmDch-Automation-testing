package tests.update;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateTest extends BaseTest {
    @Test
    public void testUpdateButton(){
        Assert.assertEquals(homePage.clickAddToCartButton().getUpdateMessage(),"Cart updated.","Not match");
    }
}
