//package steps;
//import data.LoadProperties;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.pages.HomePage;
//import org.pages.UserLoginPage;
//import org.testng.Assert;
//import testCases.TestBase;
//
//public class UserLogin extends TestBase {
//
//    HomePage homePageObject;
//    UserLoginPage userLoginPage;
//
//    String email = LoadProperties.userData.getProperty("email");
//    String password = LoadProperties.userData.getProperty("password");
//
//    @Given("the user in the homepage")
//    public void the_user_in_the_homepage() {
//        // Write code here that turns the phrase above into concrete actions
//
//        homePageObject = new HomePage(driver);
//        homePageObject.loginPage();
//
//
//    }
//    @When("I entered the user data")
//    public void i_entered_the_user_data() {
//        // Write code here that turns the phrase above into concrete actions
//        userLoginPage = new UserLoginPage(driver);
//        userLoginPage.userLogin(email,password);
//
//    }
//    @Then("The user page displayed successfully")
//    public void the_user_page_displayed_successfully() {
//        // Write code here that turns the phrase above into concrete actions
//        Assert.assertTrue(userLoginPage.successLogin.getText().contains("Tools"));
//
//    }
//}
