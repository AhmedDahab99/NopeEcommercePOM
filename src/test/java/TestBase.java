import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    protected WebDriver driver;
    protected HomePage homePageObject;

    @BeforeClass
    public  void setup(){
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        homePageObject =new HomePage(driver);
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }
}
