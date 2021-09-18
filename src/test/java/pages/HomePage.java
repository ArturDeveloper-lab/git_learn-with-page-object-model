package pages;

import baseConfig.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseConfig {

    WebDriver driver; //instance

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void goToSupport(){
       driver.findElement(By.linkText("Support")).click();
    }

    public void goToSignUP(){
        driver.findElement(By.cssSelector(".signUp")).click();

    }

    public void goToSignIn(){
      //driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));
      driver.findElement(By.cssSelector(".login")).click();
    }

    public void goToZohoEdu(){

    }

    public void goToLearnMore(){

    }

    public void validateFooterLinks(){

    }
}
