package tests.store;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTest extends BaseTest {
    @Test
    public void testPriceByFilter(){
       var text= homePage.clickStore().filterByPrice();
        Assert.assertEquals(text,"$75.00","Not match");
    }
}
