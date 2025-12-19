package tests.reset;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnSeccessfulRestPasswordTest extends BaseTest {
    @Test
    public void testUnSuccessfulResetPassword(){
        var resetPasswordTest= homePage.clickAccount().clickOnPasswordReset().unSuccessfulResetPassoword("");
        Assert.assertEquals(resetPasswordTest,"Enter a username or email address.","Not match");
    }
}
