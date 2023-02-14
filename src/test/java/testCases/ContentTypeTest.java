package testCases;

import data.LoadProperties;
import org.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContentTypeTest extends TestBase {

    //     DDT file properties
    String email = LoadProperties.userData.getProperty("email");
    String password = LoadProperties.userData.getProperty("password");
    String NewsTitle = LoadProperties.userData.getProperty("NewsTitle");
    String NewsMainCategory = LoadProperties.userData.getProperty("NewsMainCategory");
    String TeaserFiled = LoadProperties.userData.getProperty("TeaserFiled");
    String DescriptionFiled = LoadProperties.userData.getProperty("DescriptionFiled");
    String Tags = LoadProperties.userData.getProperty("Tags");
    String GeoRegion = LoadProperties.userData.getProperty("GeoRegion");
    String NewsCpProducts = LoadProperties.userData.getProperty("NewsCpProducts");
    String NewsSeeds = LoadProperties.userData.getProperty("NewsSeeds");
    String NewsTarget = LoadProperties.userData.getProperty("NewsTarget");
    String title = LoadProperties.userData.getProperty("titleLandingPage");
    String EventTitle = LoadProperties.userData.getProperty("EventTitle");
    String StartDate = LoadProperties.userData.getProperty("StartDate");
    String Time = LoadProperties.userData.getProperty("Time");
    String CommentAddress = LoadProperties.userData.getProperty("CommentAddress");
    String EventLabel = LoadProperties.userData.getProperty("EventLabel");
    String RelatedEventFiled = LoadProperties.userData.getProperty("RelatedEventFiled");
    String SalesFiled = LoadProperties.userData.getProperty("SalesFiled");
    String FinalDate = LoadProperties.userData.getProperty("FinalDate");
    String BlogTitle = LoadProperties.userData.getProperty("BlogTitle");
    String SecondTitle = LoadProperties.userData.getProperty("SecondTitle");
    String ContactInfoTitle = LoadProperties.userData.getProperty("ContactInfoTitle");
    String Phone = LoadProperties.userData.getProperty("Phone");
    String Site = LoadProperties.userData.getProperty("Site");

    String StreetAddress = LoadProperties.userData.getProperty("StreetAddress");
    String PostalCode = LoadProperties.userData.getProperty("PostalCode");
    String City = LoadProperties.userData.getProperty("City");
    String CompanyName = LoadProperties.userData.getProperty("CompanyName");
    String Location = LoadProperties.userData.getProperty("Location");
    String Business = LoadProperties.userData.getProperty("Business");
    String WebURL = LoadProperties.userData.getProperty("WebURL");
    String FAQTitle = LoadProperties.userData.getProperty("FAQTitle");
    String Question = LoadProperties.userData.getProperty("Question");







    // Login Test case

    HomePage homePageObject;
    UserLoginPage userLoginPage;
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
        newsPage.AddNewsTeaser(TeaserFiled);
        newsPage.switchToFrame(DescriptionFiled);
        newsPage.TaxonomyDropdown();
        newsPage.AddTags(Tags);
        newsPage.AddGeoRegion(GeoRegion);
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

    // Add Event Page
    EventsPage eventsPage;

    @Test (priority = 4)
    public void UserCanAddEvent()  {
        contentPage = new ContentPage(driver);
        contentPage.openContentPage();
        contentPage.AddContents();
        contentPage.AddEventPage();
        eventsPage = new EventsPage(driver);
        eventsPage.SelectEventLanguage();
        eventsPage.AddEventName(EventTitle);
        eventsPage.SelectEventItemType();
        eventsPage.EnableEndDate();
        eventsPage.EnableTimezone();
        eventsPage.AddEventStartDate(StartDate,Time);
        eventsPage.AddEventFinalDate(FinalDate, Time);
        eventsPage.SelectTimeZone();
        eventsPage.AddEventTeaser(TeaserFiled);
        eventsPage.switchToFrameEventDescription(DescriptionFiled);
        eventsPage.AddEventThumbnailImage();
        eventsPage.AddEventHomepageImage();
        eventsPage.AddEventBannerImage();
        eventsPage.AddEventGeoRegion(GeoRegion);
        eventsPage.AddressDropdown();
        eventsPage.AddEventAddress(CommentAddress);
        eventsPage.AddEventRegistration(StartDate);
        eventsPage.AddEventOverview(DescriptionFiled);
        eventsPage.AddEventLogistics(DescriptionFiled, EventLabel);
        eventsPage.AddEventAgenda(DescriptionFiled, EventLabel);
        eventsPage.AddEventRelatedEvent(RelatedEventFiled);
        eventsPage.AddEventSalesRepresentative(SalesFiled);
        eventsPage.SaveEventNode();
        eventsPage.DeleteEvent();

    }

    // Add Blog Page
    BlogEntryPage blogEntryPage;
    @Test (priority = 5)
    public void UserCanAddBlogPage() throws InterruptedException {
        contentPage = new ContentPage(driver);
        contentPage.openContentPage();
        contentPage.AddContents();
        contentPage.AddBlogPage();
        blogEntryPage = new BlogEntryPage(driver);
        blogEntryPage.SelectBlogLanguage();
        blogEntryPage.AddBlogTitle(BlogTitle);
        blogEntryPage.SelectBlogAuthor();
        blogEntryPage.SelectBlogType();
        blogEntryPage.AddThumbnailImage();
        blogEntryPage.AddBlogBody(DescriptionFiled);
        blogEntryPage.DisplayAuthorName();
        blogEntryPage.BlogVisibility();
        blogEntryPage.CustomerGroup();
        blogEntryPage.RatingOptions();
        blogEntryPage.CommentOption();
        blogEntryPage.SaveBlogNode();
        blogEntryPage.DeleteBlog();

    }

    ContactInformationPage contactInformationPage;

    @Test (priority = 6)
    public void UserCanAddContactInfoPage() throws InterruptedException {
        contentPage = new ContentPage(driver);
        contentPage.openContentPage();
        contentPage.AddContents();
        contentPage.AddContactInfoPage();
        contactInformationPage = new ContactInformationPage(driver);
        contactInformationPage.AddFirstContactInfoTitle(ContactInfoTitle);
        contactInformationPage.AddContactInfoBody(DescriptionFiled);
//        contactInformationPage.AddressSection(StreetAddress, PostalCode, City);
        contactInformationPage.SelectContactInfoCountry();
        contactInformationPage.AddPhoneAndSite(Phone, Site);
        contactInformationPage.AddContactInfoLogoImage();
        contactInformationPage.Add2ndTitle(SecondTitle);
        contactInformationPage.SaveBlogNode();
        contactInformationPage.DeleteContactInfo();

    }

    DistributorPage distributorPage;
    @Test(priority = 7)
    public void UserCanAddDistributorPage(){
        contentPage = new ContentPage(driver);
        contentPage.openContentPage();
        contentPage.AddContents();
        contentPage.AddDistributorPage();
        distributorPage = new DistributorPage(driver);
        distributorPage.DistributorCompanyName(CompanyName);
        distributorPage.SelectDistributorLanguage();
        distributorPage.DistributorRegions();
        distributorPage.DistributorAdditionalProperties();
        distributorPage.AddPhoneEmailWebDistributor(Phone, email, WebURL);
        distributorPage.DistributorLocationAndBusiness(Location, Business);
        distributorPage.SwitchToDistributorIframe(DescriptionFiled);
        distributorPage.SaveDistributorNode();
        distributorPage.DeleteDistributor();
    }

    FAQPage faqPage;

    @Test (priority = 8)
    public void UserCanAddFAQPage(){
        contentPage = new ContentPage(driver);
        contentPage.openContentPage();
        contentPage.AddContents();
        contentPage.AddFAQPage();
        faqPage = new FAQPage(driver);
        faqPage.FAQTitle(FAQTitle);
        faqPage.SelectFAQLanguage();
        faqPage.SwitchToBodyIframe(DescriptionFiled);
        faqPage.SwitchToDistributorIframe(DescriptionFiled, Question);
        faqPage.AddAccordionItem(DescriptionFiled, Question);
        faqPage.AddSecondAccordion(DescriptionFiled, Question);
        faqPage.FAQTags(Tags);
        faqPage.SaveFAQNode();
        faqPage.DeleteFAQ();

    }

}
