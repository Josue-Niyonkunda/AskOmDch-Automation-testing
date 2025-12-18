package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordReset {
    private WebDriver driver;
    public PasswordReset(WebDriver driver) {
        this.driver=driver;
    }
    public String ResetPassoword(String username){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement input= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-Input.woocommerce-Input--text.input-text")));
       input.sendKeys(username);
       driver.findElement(By.cssSelector(".woocommerce-Button.button")).click();
      return driver.findElement(By.cssSelector(".woocommerce-message")).getText();
    }
}
