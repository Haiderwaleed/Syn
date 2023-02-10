package testCases;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TestBase {

    // initialize the driver and close the driver
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("headless") String browserName)
    {
        if
        (browserName.equalsIgnoreCase("chrome")){

            // Set the path to the Chrome driver
            System.setProperty (ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            String ChromePath =  System.getProperty("user.dir")+"\\ChromeDriver\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", ChromePath);

            // insecure connection / untrusted certificate
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);

            driver = new ChromeDriver(options);
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-web-security");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");

            // Headless browser

        } else if (browserName.equalsIgnoreCase("headless")) {

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ChromeDriver\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--proxy-server='direct://'");
            options.addArguments("--proxy-bypass-list=*");
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);


        }

        String userNameAuth = "Syngenta";
        String userPasswordAuth = "Syngenta1";
        String URL = "https://"+userNameAuth+":"+userPasswordAuth+"@py.syngentacpd9.acsitefactory.com";
        driver.get(URL);
        driver.manage().window().maximize();


    }
    @AfterMethod
    public void takeScreenshotsFailed(ITestResult FailedResult) throws IOException {
        if (ITestResult.FAILURE == FailedResult.getStatus()){
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots_Fail/"+ FailedResult.getName()+".png"));

        }

    }

//    @AfterMethod
//    public void takeScreenshotsSuccess(ITestResult PassResult) throws IOException {
//        if (ITestResult.SUCCESS == PassResult.getStatus()) {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File source = ts.getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(source, new File("./Screenshots_Success/" + PassResult.getName() + ".png"));
//
//        }
//    }

    @AfterSuite
    public void stopDriver()
    {

        driver.quit();
    }
}
