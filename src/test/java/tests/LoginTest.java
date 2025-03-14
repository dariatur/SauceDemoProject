package tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends Preconditions {

    @Test(description = "login with empty username field")
    public void loginWithEmptyUsernameTest(){
        loginSteps.loginAndWaitForPageOpened(userWithEmptyUsername);
        Assert.assertEquals(loginPage.getErrorMessageText(), LoginPage.EMPTY_FIELD_USERNAME_ERROR_TEXT);
    }

    @Test(description = "login with empty password field")
    public void loginWithEmptyPasswordTest(){
        loginSteps.loginAndWaitForPageOpened(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMessageText(), LoginPage.EMPTY_FIELD_PASSWORD_ERROR_TEXT);
    }

    @Test(description = "login with empty fields")
    public void loginWithEmptyFieldsTest(){
        loginSteps.loginAndWaitForPageOpened(userWithEmptyFields);
        //Assert.assertEquals(loginPage.getErrorMessageText(), LoginPage.EMPTY_FIELD_USERNAME_ERROR_TEXT);
        Assert.assertEquals(loginPage.getErrorMessageText(), LoginPage.EMPTY_FIELD_USERNAME_ERROR_TEXT);
    }

    @Test(description = "login with incorrect data")
    public void loginWithIncorrectFieldsTest(){
        loginSteps.loginAndWaitForPageOpened(userWithIncorrectFields);
        Assert.assertEquals(loginPage.getErrorMessageText(), LoginPage.INCORRECT_DATA_IN_FIELDS_ERROR_TEXT);
    }

    @Parameters({"username", "password"})
    @Test(description = "login with correct data")
    public void loginWithCorrectFieldsTest(@Optional(USERNAME) String username,
                                           @Optional(PASSWORD) String password){
        loginSteps.loginAndWaitForPageOpened(username, password);
        Assert.assertEquals(loginPage.getDriver().getCurrentUrl(), PRODUCTS_PAGE_URL);
    }

}
