import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver webDriver;
    public LoginPage(WebDriver webDriver){
        this.webDriver =webDriver;
        PageFactory.initElements(webDriver,this);
    }

    private By emailField = By.id("Email");
    private By passwordField =By.id("Password");

    private By loginButton = By.cssSelector("html>body>div:nth-of-type(6)>div:nth-of-type(3)>div>div>div>div:nth-of-type(2)>div>div:nth-of-type(2)>form>div:nth-of-type(3)>button");

    public HomePage verifyUserCanLogin(String email, String password){
        webDriver.findElement(emailField).sendKeys(email);
        webDriver.findElement(passwordField).sendKeys(password);
        webDriver.findElement(loginButton).click();
        return new HomePage(webDriver);
    }
}
