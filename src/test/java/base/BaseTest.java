package base;

import constants.Url;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest{
    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Personal\\Project\\automation-test-web\\lib\\chromedriver.exe");
        driver = new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver", "D:\\Personal\\Project\\automation-test-web\\lib\\geckodriver.exe");
//        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get(Url.BASE_URL);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
