package base;

import constants.Url;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest{
    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }
    @BeforeClass
    public void setUp(){
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.gecko.driver", "D:\\Personal\\Project\\automation-test-web\\geckodriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Url.BASE_URL);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
