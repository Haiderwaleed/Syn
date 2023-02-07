package testCases;

import data.LoadProperties;
import org.pages.HomePage;
import org.pages.UserLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUserTestCase extends TestBase
{
    HomePage homePageObject;
    UserLoginPage userLoginPage;


//     DDT file properties
    String email = LoadProperties.userData.getProperty("email");
    String password = LoadProperties.userData.getProperty("password");



    @Test
    public void UserCanLoginSuccessfully()
    {
        homePageObject = new HomePage(driver);
        homePageObject.loginPage();
        userLoginPage = new UserLoginPage(driver);
        userLoginPage.userLogin(email,password);
        Assert.assertTrue(userLoginPage.successLogin.getText().contains("Tools"));
    }


}
