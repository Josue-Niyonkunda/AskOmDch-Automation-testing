package tests.register;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterWithEmptyPasswordTest extends BaseTest {
    @Test
    //checking reregistration functionality with empty password field
    public void testRegisterWithEmptyPassword(){
        var details=homePage.clickAccount();
        details.userRegistrationDetails("josue2","josue2@gmail.com","");
        details.clickRegisterButton();
        Assert.assertEquals(details.clickRegisterButton(),"Error: Please enter an account password.","not match");
    }
}
