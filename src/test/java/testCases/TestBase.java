package testCases;

// initialize the driver and close the driver

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    @BeforeSuite
    public void startDriver()
    {
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
