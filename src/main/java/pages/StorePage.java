package pages;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class StorePage {
   private WebDriver driver;
    public StorePage(WebDriver driver){
        this.driver=driver;
    }
    public String getMenCategoriyDropdowm(String category){
        var tit=driver.findElement(By.cssSelector(".dropdown_product_cat"));
            tit.click();
        Select select=new Select(tit);
        select.selectByVisibleText(category);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.woocommerce-products-header__title.page-title")));
        return text.getText();
    }
    public String searchProduct(String text){
        driver.findElement(By.cssSelector("[type='search']")).sendKeys(text);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement text1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.woocommerce-products-header__title.page-title")));
        return text1.getText();
    }
    public String filterByPrice(){
        Actions actions= new Actions(driver);
      WebElement slider= driver.findElement(By.cssSelector(".ui-slider-handle"));
      actions.dragAndDropBy(slider,100,0).perform();
      driver.findElement(By.cssSelector("button.button[type='submit']")).click();
      var price=driver.findElement(By.cssSelector(".price span bdi")).getText();
                    return price;
    }
    public void sorting(String option){
        var optionlocator=driver.findElement(By.cssSelector("select.orderby"));
        optionlocator.click();
        Select select= new Select(optionlocator);
        select.selectByVisibleText(option);
    }



}
