package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
 @BeforeMethod
    public void sepUp(){
        driver= new ChromeDriver();
        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        homePage= new HomePage(driver);
    }
    @AfterMethod
    public void stop(){
    // driver.quit();

    }
}
