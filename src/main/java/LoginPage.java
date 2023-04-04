import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    protected WebDriver webDriver;
    LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    private final By loginButtonText = new By.ByLinkText("Log in");
    private final By emailField = new By.ById("Email");
    private final By passwordField = new By.ById("Password");
    private final By loginButton = new By.ByClassName("button-1 login-button");

    public void verifyOpeningLoginPage(){
        webDriver.findElement(loginButtonText).click();
    }
    public void verifyUserCanLogin(String email,String password){
        webDriver.findElement(emailField).sendKeys(email);
        webDriver.findElement(passwordField).sendKeys(password);
        webDriver.findElement(loginButton).click();
    }
}
