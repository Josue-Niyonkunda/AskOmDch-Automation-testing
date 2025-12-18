package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver=driver;
    }
    public String getCartPageText(){
        WebElement CartText=driver.findElement(By.tagName("h1"));
     return CartText.getText();
    }
    public void update(){
        driver.findElement(By.name("cart[a4d2f0d23dcc84ce983ff9157f8b7f88][qty]")).sendKeys(Keys.ARROW_UP);
        driver.findElement(By.name("cart[7e7e69ea3384874304911625ac34321c][qty]")).sendKeys(Keys.ARROW_UP);
        driver.findElement(By.name("cart[7e7e69ea3384874304911625ac34321c][qty]")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.name("update_cart")).click();


    }
    public String getUpdateMessage() {
        update();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-message"))).getText();

    }
    public String getDeleteMessage(){
       driver.findElement(By.cssSelector("[data-product_id='1215']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-message"))).getText();


    }

}
