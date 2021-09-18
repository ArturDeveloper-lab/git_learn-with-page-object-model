package baseConfig;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseConfig {

      /*
       webDriver -done
       Properties-done
       Logs log4j jar,.log.properties
       ExtentReports
       DB
       Excel
       Mail
     */

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    //public static Logger log = Logger.getLogger(TestBase.class);

//    public static Logger log = Logger.getLogger(TestBase.class.getName());
//    public static  MainLoginPage mainLoginPage;
//    public static Client_Management client_management;
    protected static ExtentTest test;



    //@BeforeSuite
    public static void setUp(){
        if(driver==null) {
            PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/java/properties/log4j.properties");
            try {
                fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/Config.properties");
                //log.debug("gggg");
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            }
        }
        try {
            config.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/OR.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            OR.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(config.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (config.getProperty("browser").equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.get(config.getProperty("testsiteurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicity.wait")), TimeUnit.SECONDS);

//        mainLoginPage = PageFactory.initElements(driver, MainLoginPage.class);
//        client_management = PageFactory.initElements(driver, Client_Management.class);

    }



    //@AfterSuite
//    @AfterTest
//    public void tearDown(){
//        if (driver!=null)
//            driver.quit();
//
//    }
}


