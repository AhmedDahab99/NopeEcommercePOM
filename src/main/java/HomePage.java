import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver webDriver;
    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    private final By registerButton = By.linkText("Register");

    public RegisterPage openRegisterPage(){
        webDriver.findElement(registerButton).click();
        return new RegisterPage(webDriver);
    }
}
