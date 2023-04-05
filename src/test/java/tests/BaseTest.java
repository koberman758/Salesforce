package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import pages.AccountListPage;
import pages.LoginPage;
import pages.NewAccountPage;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    AccountListPage accountListPage;
    NewAccountPage newAccountPage;

    public static final String USER = "david758-339y@force.com";
    public static final String PASSWORD = "david7587830";

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        testContext.setAttribute("driver", driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        accountListPage = new AccountListPage(driver);
         }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
        //    driver.quit();
        }
    }
}
