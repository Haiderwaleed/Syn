package testCases;

import org.pages.UserProfilePage;
import org.testng.annotations.Test;

public class UserProfileTestCase extends TestBase{
    UserProfilePage userProfilePage;

    @Test
    public void UserCanaccessTheContentPage(){
        userProfilePage = new UserProfilePage(driver);
        userProfilePage.openContentPage();
    }

}
