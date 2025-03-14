package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage implements IConstants {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasePage openPage(String url){
        driver.get(url);
        return this;
    }
}
