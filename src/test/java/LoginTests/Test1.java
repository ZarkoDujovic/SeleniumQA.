package LoginTests;

import LoginTests.Url;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    public static  void main (String[]args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katarina\\Desktop\\chromedriver.exe");
        ChromeDriver driver= new ChromeDriver();
        driver.get(Url.urlLoginPage);

        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.clear();
        inputUserName.sendKeys("standard_user");

        //set password
       WebElement inputPassword= driver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys("secret_sauce");


        WebElement btnLogin= driver.findElement(By.id("login-button"));
        btnLogin.click();

        //validacij,potvrda da je test prosao/pao
        String currentUrl=driver.getCurrentUrl();
        System.out.println((currentUrl));




        if(currentUrl.equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("PASSED");
        }

        else {

            System.out.println("FAILED");

        }
        //junit

        Assert.assertEquals("Current url is not as expected",currentUrl );
        driver.quit();

    }





}
