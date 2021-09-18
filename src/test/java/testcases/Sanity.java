package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

import static baseConfig.BaseConfig.driver;
import static baseConfig.BaseConfig.setUp;

public class Sanity {

    @BeforeMethod
    public void beforeTest() throws IOException {
        setUp();

    }

//    @AfterMethod
//    public static void closeAfterTest(){
//        if (driver!=null)
//            driver.quit();
//    }

    @Test
    public void doLogin(){
        HomePage homePage =new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToSignIn();
        loginPage.doLogin("artur.boltiansky79@gmail.com","Edwin2008!");
    }
}
