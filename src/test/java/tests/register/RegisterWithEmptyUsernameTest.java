package tests.register;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterWithEmptyUsernameTest extends BaseTest {
    @Test
    //checking reregistration functionality with empty username field
    public void testRegisterWithEmptyUsername(){
        var details=homePage.clickAccount();
        details.userRegistrationDetails("","josue2@gmail.com","niyonkunda20");
        details.clickRegisterButton();
        Assert.assertEquals(details.getTextErrorForRegister(),"Error: Please enter a valid account username.","not match");
    }
}
