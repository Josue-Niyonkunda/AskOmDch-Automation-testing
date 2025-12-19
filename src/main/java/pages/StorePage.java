package pages;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    private By formSlider= By.cssSelector(".price_slider_wrapper");
    private By filterButton=By.cssSelector("button.button[type='submit']");
    public List<Double> filterByPrice(int minV, int maxV) {
        WebElement priceSlider = driver.findElement(formSlider);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Set min and max price using JS
        js.executeScript("arguments[0].scrollIntoView({block:'center'});" +
                        "document.getElementById('min_price').value=arguments[1];" +
                        "document.getElementById('max_price').value=arguments[2];",priceSlider, minV, maxV);

        driver.findElement(filterButton).click();

        // Get all product prices after filter
        List<WebElement> prices = driver.findElements(By.cssSelector(".price"));
        List<Double> priceValues = new ArrayList<>();

        for (WebElement price : prices) {
            String text = price.getText();
            // Remove symbols, split by space, take first number
            double value = Double.parseDouble(text.replaceAll("[^0-9. ]", "").split("\\s+")[0]);
            priceValues.add(value);
        }
        return priceValues;
    }

    public void sorting(String option){
        var optionlocator=driver.findElement(By.cssSelector("select.orderby"));
        optionlocator.click();
        Select select= new Select(optionlocator);
        select.selectByVisibleText(option);
    }



}
