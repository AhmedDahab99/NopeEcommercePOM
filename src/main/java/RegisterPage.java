import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    private final WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By genderButton = By.id("gender-male");
    private final By firstNameField = By.id("FirstName");
    private final By lastNameField = By.id("LastName");
    private final By yearDropDown = By.name("DateOfBirthYear");
    private final By monthDropDown = By.name("DateOfBirthMonth");
    private final By dayDropDown = By.name("DateOfBirthDay");
    private final By emailField = By.id("Email");
    private final By companyField = By.id("Company");
    private final By passwordField = By.id("Password");
    private final By confirmPasswordField = By.id("ConfirmPassword");
    private final By registerAccountButton = By.id("register-button");


    public AccountCreatedPage fillUserData(String firstName, String lastName, String email, String password, String confirmPassword, String company, String year, String month, String day) {
        webDriver.findElement(genderButton).click();
        webDriver.findElement(firstNameField).sendKeys(firstName);
        webDriver.findElement(lastNameField).sendKeys(lastName);
        WebElement yearElement = webDriver.findElement(yearDropDown);
        WebElement monthElement = webDriver.findElement(monthDropDown);
        WebElement dayElement = webDriver.findElement(dayDropDown);
        Select yearSelect = new Select(yearElement);
        Select monthSelect = new Select(monthElement);
        Select daySelect = new Select(dayElement);
        yearSelect.selectByVisibleText(year);
        monthSelect.selectByVisibleText(month);
        daySelect.selectByVisibleText(day);
        webDriver.findElement(emailField).sendKeys(email);
        webDriver.findElement(companyField).sendKeys(company);
        webDriver.findElement(passwordField).sendKeys(password);
        webDriver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        webDriver.findElement(registerAccountButton).click();
        return new AccountCreatedPage(webDriver);
    }
}
