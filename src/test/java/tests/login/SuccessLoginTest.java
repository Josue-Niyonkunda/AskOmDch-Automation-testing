package tests.login;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessLoginTest extends BaseTest {
    @Test
    public void testLogin(){
        var contact=homePage.clickAccount();
        contact.userCredentials("josueniyonkunda","niyonkunda20");

        Assert.assertEquals(contact.clickLoginButton(),"Hello josueniyonkunda (not josueniyonkunda? Log out)","Not match");
    }
}
