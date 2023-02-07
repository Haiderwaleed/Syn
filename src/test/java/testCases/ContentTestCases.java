package testCases;

import org.pages.ContentPage;
import org.testng.annotations.Test;

public class ContentTestCases extends TestBase{
    ContentPage contentPage;

    @Test
    public void UserCanAddContents(){
        contentPage = new ContentPage(driver);
        contentPage.AddContents();
    }

}
