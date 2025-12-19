package tests.store;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FilterTest extends BaseTest {
    @Test
    public void testPriceByFilter() {
        int min = 10;
        int max = 150;
        List<Double> prices = homePage.clickStore().filterByPrice(min, max);
        for (double value : prices) {
            Assert.assertTrue(value >= min && value <= max,
                    "Price out of range: " + value);
        }
    }

}
