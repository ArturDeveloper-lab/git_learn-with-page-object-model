package pages;

import baseConfig.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseConfig {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver= driver;
    }


    public void doLogin(String username,String password){
        //driver.switchTo().frame("zohoiam");
        driver.findElement(By.id("login_id")).sendKeys(username);
        driver.findElement(By.id("nextbtn")).click();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("nextbtn")).click();
    }


}
