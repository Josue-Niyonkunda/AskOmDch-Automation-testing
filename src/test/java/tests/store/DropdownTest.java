package tests.store;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {
    @Test
    private void testStore(){

        Assert.assertEquals(homePage.clickStore().getMenCategoriyDropdowm("Men’s Jeans  (4)"),"Men's Jeans","Not match");
        Assert.assertEquals(homePage.clickStore().getMenCategoriyDropdowm("Purses And Handbags  (1)"),"Purses And Handbags","Not match");
        Assert.assertEquals(homePage.clickStore().getMenCategoriyDropdowm("Women’s Shoes  (1)"),"Women's Shoes","Not match");

    }
}
