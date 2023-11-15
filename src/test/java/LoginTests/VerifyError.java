package LoginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VerifyError {



        public static void main(String[] args) {;

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katarina\\Desktop\\chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();
            driver.get(Url.urlLoginPage);

            String  getErrorMessage;
            WebElement inputUserName = driver.findElement(By.id("user-name"));
            inputUserName.clear();
            inputUserName.sendKeys("standard_user");

            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.clear();
            inputPassword.sendKeys("");



            WebElement btnLogin = driver.findElement(By.id("login-button"));
            btnLogin.click();

            WebElement h3error= driver.findElement(By.xpath("//h3[@data-test='error']"));
            System.out.println(h3error.getText());
                getErrorMessage=h3error.getText();

                System.out.println("Test");
            Assert.assertEquals(getErrorMessage,"Epic sadface: Password is required");
            driver.quit();
        }

    }

