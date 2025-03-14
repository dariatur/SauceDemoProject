package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.HeaderPage;
import pages.LoginPage;
import pages.ProductsPage;
import steps.HeaderSteps;
import steps.LoginSteps;
import steps.ProductsSteps;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest implements IConstants, ITestConstants {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected HeaderPage headerPage;
    protected ProductsSteps productsSteps;
    protected LoginSteps loginSteps;
    protected HeaderSteps headerSteps;

    @BeforeMethod
    public void initTest(ITestContext iTestContext) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
        iTestContext.setAttribute("driver", driver);
    }

    public void initPages(){
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        loginSteps = new LoginSteps(driver);
        productsSteps = new ProductsSteps(driver);
        headerSteps = new HeaderSteps(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }
}


