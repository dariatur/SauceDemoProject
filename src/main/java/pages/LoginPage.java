package pages;

import entity.User;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class LoginPage extends BasePage{
    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");
    public static final String EMPTY_FIELD_USERNAME_ERROR_TEXT = "Epic sadface: Username is required";
    public static final String EMPTY_FIELD_PASSWORD_ERROR_TEXT = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS_ERROR_TEXT = "Epic sadface: Username and password do not match any user in this service";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage login(User user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user.getUsername());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Login with username {}, password {}", user.getUsername(), user.getPassword());
        return new ProductsPage(driver);
    }

    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Login with username {}, password {}", username, password);
        return new ProductsPage(driver);
    }

    public String getErrorMessageText() {
        String errorMessage = driver.findElement(ERROR_MESSAGE).getText();
        log.info("Get error message " + errorMessage);
        return errorMessage;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public LoginPage waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        log.info("Waiting until login button is visible");
        return this;
    }
    @Override
    public LoginPage openPage(String url){
        driver.get(url);
        log.info("Open login page url {}", url);
        return this;
    }
}
