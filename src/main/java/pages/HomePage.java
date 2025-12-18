package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage (WebDriver driver){
        this.driver=driver;
    }
    public void clickLink( String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
    public Account clickAccount(){
        clickLink("Account");
        return new Account(driver);
    }
    public CartPage clickAddToCartButton(){
        driver.findElement(By.cssSelector("[data-product_id='1215']")).click();
        driver.findElement(By.cssSelector("[data-product_id='1209']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement viewCart =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@class,'added_to_cart')]")
                ));
        viewCart.click();

       return new CartPage(driver);
    }
    public StorePage clickStore(){
        clickLink("Store");
        return new StorePage(driver);
    }
}
