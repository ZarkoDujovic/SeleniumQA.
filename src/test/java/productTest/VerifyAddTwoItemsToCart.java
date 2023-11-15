package productTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyAddTwoItemsToCart {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katarina\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath("//div[@class='inventory_item']"));

        for (int i = 0; i < inventoryItems.size(); i++) {

            WebElement item = inventoryItems.get(i);
            WebElement itemName = item.findElement(By.xpath(".//div[@class='inventory_item_name ']"));

            if (itemName.getText().equals("Sauce Labs Backpack")) {
                WebElement button = item.findElement(By.xpath(".//button"));
                button.click();

                System.out.println("Item added");
                break;

            }
        }
    }
}
