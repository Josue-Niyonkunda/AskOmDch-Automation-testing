package tests.login;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithEmptyUsernameTest extends BaseTest {
    @Test
    public void testUnSuccessfulLogin(){
        var contact=homePage.clickAccount();
        contact.userCredentials("","niyonkunda20");
        contact.clickLoginButton();
        Assert.assertEquals(contact.getErrorText(),"Error: Username is required.","Not match");
    }
}
