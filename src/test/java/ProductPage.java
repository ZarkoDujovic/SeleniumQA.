package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import java.util.List;

public class ProductPage {

    public ChromeDriver driver;

    public ProductPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    public void addProductToCart(String productName) {
        //nalazimo inventory_list
        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));
        //WebElement inventoryItems = inventoryList.findElement(By.xpath("//div[@class='inventory_item']"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath(".//div[@class='inventory_item']"));

        for(int i = 0; i < inventoryItems.size(); i++) {
            WebElement item = inventoryItems.get(i);
            WebElement itemName = item.findElement(By.xpath(".//div[@class='inventory_item_name ']"));
            if(itemName.getText().equals(productName)) {
                //WebElement button = item.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']"));
                WebElement button = item.findElement(By.xpath(".//button"));
                button.click();
                System.out.println("Item added");
                break;
            }
        }
    }

    public WebElement getCartNumber() {
        return driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
    }

    public String getCartNumberText() {
        return getCartNumber().getText();
    }

    public void closePage() {
        driver.quit();
    }


}