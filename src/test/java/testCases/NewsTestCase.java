package testCases;

import data.LoadProperties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.pages.ContentPage;
import org.pages.NewsPage;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class NewsTestCase extends TestBase{
    ContentPage contentPage;
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


    @Test
    public void UserCanAddNewsItem() throws InterruptedException {
        contentPage = new ContentPage(driver);
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
