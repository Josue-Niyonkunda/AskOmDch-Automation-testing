package tests.register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterWithinvalidEmailTest extends BaseTest {
    @Test
    //Checking registration fuctionality with no email
    public void testRegisterWithinvalidEmail(){
        var details=homePage.clickAccount();
        details.userRegistrationDetails("josue","","niyonkunda20");
        details.clickRegisterButton();
        Assert.assertEquals(details.getTextErrorForRegister(),"Error: Please provide a valid email address.","not match");
    }
}
