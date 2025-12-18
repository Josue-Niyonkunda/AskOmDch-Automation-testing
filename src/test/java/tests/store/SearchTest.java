package tests.store;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test
    public void testSearch(){
      var test= homePage.clickStore().searchProduct("shirt");
        Assert.assertEquals(test,"Search results: “shirt”","Not match");

    }
}
