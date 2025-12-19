package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Account {
   private WebDriver driver;
    private By usernameField=By.id("username");
    private By passwordField=By.id("password");
    private By loginButton=By.name("login");
    private By regUsernameField=By.id("reg_username");
    private By emailField=By.name("email");
    private  By regPasswordField=By.id("reg_password");
    private By registerButton=By.name("register");
     Account(WebDriver driver) {
       this.driver=driver;
    }
    public void userCredentials(String username,String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);

    }
    public String clickLoginButton(){
        driver.findElement(loginButton).click();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p:nth-child(2)"))));
        WebElement text=driver.findElement(By.cssSelector("p:nth-child(2)"));
        return text.getText();
    }

    public String getErrorText(){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".woocommerce-error"))));

        WebElement text=driver.findElement(By.cssSelector(".woocommerce-error"));
        return text.getText();
    }
    public void userRegistrationDetails (String username1,String email1,String password1){
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.findElement(regUsernameField).sendKeys(username1);
         driver.findElement(emailField).sendKeys(email1);
         driver.findElement(regPasswordField).sendKeys(password1);
    }
    public String clickRegisterButton(){
        driver.findElement(registerButton).click();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".woocommerce-error"))));
        WebElement errorMessage=driver.findElement(By.cssSelector(".woocommerce-error"));
        return errorMessage.getText();
    }
    public PasswordReset clickOnPasswordReset(){
         driver.findElement(By.linkText("Lost your password?")).click();
         return new PasswordReset(driver);
    }

    }


