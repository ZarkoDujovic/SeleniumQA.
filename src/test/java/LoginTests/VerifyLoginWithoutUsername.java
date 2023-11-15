package LoginTests;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLoginWithoutUsername {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katarina\\Desktop\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(Url.urlLoginPage);


        //set password
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys("secret_sauce");


        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        //validacij,potvrda da je test prosao/pao
        String currentUrl = driver.getCurrentUrl();
        System.out.println((currentUrl));


        if (currentUrl.equals("https://www.saucedemo.com")) {
            System.out.println("PASSED");
        } else {

            System.out.println("FAILED");

        }
        driver.quit();

    }
}







