package testCases;

import data.LoadProperties;
import org.pages.ContentPage;
import org.pages.LandingPage;
import org.testng.annotations.Test;

public class AddLandingPageTestCase extends TestBase{
    ContentPage contentPage;
    LandingPage landingPage;
    String title = LoadProperties.userData.getProperty("titleLandingPage");

@Test
    public void UserCanAddLandingPageSuccessfully(){
        contentPage = new ContentPage(driver);
        contentPage.AddLandingPage();
        landingPage = new LandingPage(driver);
        landingPage.LanguageSelectorOption();
        landingPage.AddTitleLandingPage(title);
        landingPage.SaveLandingPage();
        landingPage.DeleteLandingPage();
    }
}
