package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {
    @Test
    public void testLogin(){
       var contact=homePage.clickAccount();
               contact.userCredentials("josueniyonkunda","niyonkunda20");
               contact.clickLoginButton();
        Assert.assertEquals(contact.getText(),"Hello josueniyonkunda (not josueniyonkunda? Log out)","Not match");
    }
    @Test
    public void testLoginWithEmptyUsername(){
        var contact=homePage.clickAccount();
        contact.userCredentials("","niyonkunda20");
        contact.clickLoginButton();
        Assert.assertEquals(contact.getErrorText(),"Error: Username is required.","Not match");
    }
    @Test
    public void testLoginWithEmptyPassword(){
        var contact=homePage.clickAccount();
        contact.userCredentials("josueniyonkunda","");
        contact.clickLoginButton();
        Assert.assertEquals(contact.getErrorText(),"Error: The password field is empty.","Not match");
    }

    @Test
    //checking reregistration functionality
    public void testRegister(){
        var details=homePage.clickAccount();
         details.userRegistrationDetails("josue","josue@gmail.com","niyonkunda20");
         details.clickRegisterButton();
         Assert.assertEquals(details.getTextErrorForRegister(),"Error: An account is already registered with your email address. Please log in.","not match");
    }
    @Test
    //Checking registration fuctionality with no email
    public void testRegisterWithinvalidEmail(){
        var details=homePage.clickAccount();
        details.userRegistrationDetails("josue","","niyonkunda20");
        details.clickRegisterButton();
        Assert.assertEquals(details.getTextErrorForRegister(),"Error: Please provide a valid email address.","not match");
    } @Test
    //checking reregistration functionality with empty username field
    public void testRegisterWithEmptyUsername(){
        var details=homePage.clickAccount();
        details.userRegistrationDetails("","josue2@gmail.com","niyonkunda20");
        details.clickRegisterButton();
        Assert.assertEquals(details.getTextErrorForRegister(),"Error: Please enter a valid account username.","not match");
    }
    @Test
    //checking reregistration functionality with empty password field
    public void testRegisterWithEmptyPassword(){
        var details=homePage.clickAccount();
        details.userRegistrationDetails("josue","josue2@gmail.com","");
        details.clickRegisterButton();
        Assert.assertEquals(details.getTextErrorForRegister(),"Error: Please enter an account password.","not match");
    }
    @Test
    public void testSuccessfulResetPassword(){
      var resetPasswordTest= homePage.clickAccount().clickOnPasswordReset().ResetPassoword("josue");
        Assert.assertEquals(resetPasswordTest,"Password reset email has been sent.","Not match");
    }

}
