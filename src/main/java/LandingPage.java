import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private final WebDriver webDriver;
    public LandingPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    private final By registerButton = By.linkText("Register");
    private final By loginButton = By.linkText("Log in");

    public RegisterPage openRegisterPage(){
        webDriver.findElement(registerButton).click();
        return new RegisterPage(webDriver);
    }

    public LoginPage openLoginPage(){
        webDriver.findElement(loginButton).click();
        return new LoginPage(webDriver);
    }

}
