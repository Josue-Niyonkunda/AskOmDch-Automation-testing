package tests.reset;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulRetPasswordTest extends BaseTest {
    @Test
    public void testSuccessfulResetPassword(){
      var resetPasswordTest= homePage.clickAccount().clickOnPasswordReset().resetPassoword("josue");
        Assert.assertEquals(resetPasswordTest,"Password reset email has been sent.","Not match");
    }

}
