package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HeaderSteps extends BaseSteps{

    public HeaderSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Login and open cart from header")
    public HeaderSteps loginAndOpenCart(String username, String password){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL)
                .waitForPageOpened()
                .login(username, password);
        headerPage.openCartPage();
        return this;
    }

    @Step("Login and open menu from header")
    public HeaderSteps loginAndOpenMenu(String username, String password){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL)
                    .login(username, password);
        headerPage.getMenuButton().click();
        return this;
    }
}
