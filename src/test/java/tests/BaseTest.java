package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import pages.AccountsPage;
import pages.LoginPage;


import java.time.Duration;

//@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    AccountsPage accountsPage;
    public static final String USER = "david758-339y@force.com";
    public static final String PASSWORD = "david7587830";

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        testContext.setAttribute("driver", driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);
         }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
     //       driver.quit();
        }
    }
}
