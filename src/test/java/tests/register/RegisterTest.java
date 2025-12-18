package tests.register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    @Test
    //checking reregistration functionality
    public void testRegister(){
        var details=homePage.clickAccount();
        details.userRegistrationDetails("josue","josue@gmail.com","niyonkunda20");
        details.clickRegisterButton();
        Assert.assertEquals(details.getTextErrorForRegister(),"Error: An account is already registered with your email address. Please log in.","not match");
    }
}
