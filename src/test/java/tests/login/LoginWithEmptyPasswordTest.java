package tests.login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithEmptyPasswordTest extends BaseTest {
    @Test
    public void testLoginWithEmptyPassword(){
        var contact=homePage.clickAccount();
        contact.userCredentials("josueniyonkunda","");
        contact.clickLoginButton();
        Assert.assertEquals(contact.getErrorText(),"Error: The password field is empty.","Not match");
    }
}
