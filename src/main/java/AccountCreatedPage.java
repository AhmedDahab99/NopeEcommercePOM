import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    protected WebDriver webDriver;
//    public final By assertAccountCreation = new By.ByXPath("//div[text()='Your registration completed']");
    private final By completeRegistrationButton = new By.ByXPath("//a[@class='button-1 register-continue-button']");

    public AccountCreatedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage verifyAccountCreatedSuccessfullyAndNavigateToHome() {
        webDriver.findElement(completeRegistrationButton).click();
//        webDriver.findElement(assertAccountCreation);
        return new LoginPage(webDriver);
    }
}
