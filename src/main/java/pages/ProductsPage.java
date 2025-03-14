package pages;

import entity.Product;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProductsPage extends HeaderPage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<Product> getProductsList(){
        List<WebElement> elements = driver.findElements(By.className("inventory_item"));
        List<Product> result = new ArrayList<>();
        for (WebElement element: elements){
            result.add(new Product(element));
        }
        log.info("Get products list: " + result);
        return result;
    }

    public Product getProductByName(String name){
        List<Product> products = getProductsList();
        Product product = null;
        for (Product elem: products){
            if(elem.getName().equals(name)){
                product = elem;
            }
        }
        log.info("Get product by name {}, product: {}", name, product);
        return product;
    }

    public int getProductsAmount(){
        log.info("Get products amount: " + getProductsList().size());
        return getProductsList().size();
    }
}
