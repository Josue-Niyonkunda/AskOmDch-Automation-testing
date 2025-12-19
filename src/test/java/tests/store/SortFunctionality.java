package tests.store;
import base.BaseTest;
import org.testng.annotations.Test;

public class SortFunctionality extends BaseTest {
    @Test
    public void testSorting(){
        homePage.clickStore().sorting("Sort by average rating");
        homePage.clickStore().sorting("Sort by popularity");
        homePage.clickStore().sorting("Default sorting");
        homePage.clickStore().sorting("Sort by latest");
    }
}
