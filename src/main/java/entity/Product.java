package entity;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Log4j2
public class Product extends BaseEntity {
    private String name;
    private String price;
    private WebElement cartButton;

    public Product(WebElement rootElement) {
        super(rootElement);
        name = rootElement.findElement(By.className("inventory_item_name")).getText();
        price = rootElement.findElement(By.className("inventory_item_price")).getText();
        cartButton = rootElement.findElement(By.className("btn"));
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price;
    }

    public WebElement getButton(){
        return rootElement.findElement(By.className("btn"));
    }

    public String getButtonText(){
        return rootElement.findElement(By.className("btn")).getText();
    }

    public void addToCart(){
        log.info("Add product {} to cart", this);
        cartButton.click();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
