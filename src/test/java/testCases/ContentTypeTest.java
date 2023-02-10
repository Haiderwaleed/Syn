package testCases;

import data.LoadProperties;
import org.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContentTypeTest extends TestBase{

    // Login Test case

    HomePage homePageObject;
    UserLoginPage userLoginPage;


    //     DDT file properties
    String email = LoadProperties.userData.getProperty("email");
    String password = LoadProperties.userData.getProperty("password");



    @Test (priority = 1)
    public void UserCanLoginSuccessfully()
    {
        homePageObject = new HomePage(driver);
        homePageObject.loginPage();
        userLoginPage = new UserLoginPage(driver);
        userLoginPage.userLogin(email,password);
        Assert.assertTrue(userLoginPage.successLogin.getText().contains("Tools"));
    }


    // Add landing page

    ContentPage contentPage;
    LandingPage landingPage;
    String title = LoadProperties.userData.getProperty("titleLandingPage");

    @Test (priority = 2)
    public void UserCanAddLandingPageSuccessfully(){
        contentPage = new ContentPage(driver);
        contentPage.openContentPage();
        contentPage.AddContents();
        contentPage.AddLandingPage();
        landingPage = new LandingPage(driver);
        landingPage.LanguageSelectorOption();
        landingPage.AddTitleLandingPage(title);
        landingPage.SaveLandingPage();
        landingPage.DeleteLandingPage();
    }

    // Add news
    NewsPage newsPage;

    // DDT
    String NewsTitle = LoadProperties.userData.getProperty("NewsTitle");
    String NewsMainCategory = LoadProperties.userData.getProperty("NewsMainCategory");
    String NewsTeaser = LoadProperties.userData.getProperty("NewsTeaser");
    String NewsBody = LoadProperties.userData.getProperty("NewsBody");
    String Tags = LoadProperties.userData.getProperty("Tags");
    String NewsGeoRegion = LoadProperties.userData.getProperty("NewsGeoRegion");
    String NewsCpProducts = LoadProperties.userData.getProperty("NewsCpProducts");
    String NewsSeeds = LoadProperties.userData.getProperty("NewsSeeds");
    String NewsTarget = LoadProperties.userData.getProperty("NewsTarget");


    @Test (priority = 3)
    public void UserCanAddNewsItem() throws InterruptedException {
        contentPage = new ContentPage(driver);
        contentPage.openContentPage();
        contentPage.AddContents();
        contentPage.AddNewsPage();
        newsPage = new NewsPage(driver);
        newsPage.SelectNewLanguage();
        newsPage.AddNewsTitle(NewsTitle);
        newsPage.SelectNewsItemType();
        newsPage.AddNewsMainCategory(NewsMainCategory);
        newsPage.AddNewsTeaser(NewsTeaser);
        newsPage.switchToFrame(NewsBody);
        newsPage.TaxonomyDropdown();
        newsPage.AddTags(Tags);
        newsPage.AddGeoRegion(NewsGeoRegion);
        newsPage.MediaDropDown();
        newsPage.AddThumbnailImage();
        newsPage.AddMainImage();
        newsPage.RelatedContentDropdown();
        newsPage.AddCpProducts(NewsCpProducts);
        newsPage.AddSeeds(NewsSeeds);
        newsPage.AddTargets(NewsTarget);
        newsPage.SaveNewsNode();
        newsPage.DeleteNews();
    }

}
