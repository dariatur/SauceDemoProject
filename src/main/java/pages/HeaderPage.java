package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
@Log4j2
public class HeaderPage extends BasePage{
    public static final By CART_BUTTON = By.xpath("//*[@data-test='shopping-cart-link']");
    public static final By MENU_BUTTON = By.id("react-burger-menu-btn");
    public static final By MENU_ELEM = By.className("bm-menu-wrap");
    public static final By HEADER_ELEM = By.id("header_container");
    private LoginPage loginPage;

    public HeaderPage(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public List<WebElement> getHeaderElems(){
        List<WebElement> headerElements = driver.findElements(HEADER_ELEM);
        log.info("Find header element: " + headerElements);
        return headerElements;
    }

    public WebElement getHeaderElem(){
        WebElement header = driver.findElement(HEADER_ELEM);
        log.info("Find header element: " + header);
        return header;
    }

    public WebElement getMenuButton(){
        log.info("Get menu button in header");
        return driver.findElement(MENU_BUTTON);
    }

    public WebElement getMenuElement(){
        log.info("Get menu element in header");
        return driver.findElement(MENU_ELEM);
    }

    public CartPage openCartPage(){
        log.info("Click on cart button and open cart page");
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }

    public boolean isMenuHidden(){
        String hiddenAttr = getMenuElement().getDomAttribute("aria-hidden");
        log.info("Get attribute of menu {} to check if it's hidden", hiddenAttr);
        return Boolean.parseBoolean(hiddenAttr);
    }

    public WebDriver getDriver(){
        return driver;
    }
}
