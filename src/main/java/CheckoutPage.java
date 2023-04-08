import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver webDriver;

    public CheckoutPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By firstNameField = By.id("BillingNewAddress_FirstName");
    private final By lastNameField = By.id("BillingNewAddress_LastName");
    private final By emailField = By.id("BillingNewAddress_Email");
    private final By countryDropDown = By.id("BillingNewAddress_CountryId");
    private final By stateDropDown = By.id("BillingNewAddress_StateProvinceId");
    private final By cityField = By.id("BillingNewAddress_City");
    private final By address1Field = By.id("BillingNewAddress_Address1");
    private final By postalCodeField = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneField = By.id("BillingNewAddress_PhoneNumber");
    private final By continueAddressButton = By.xpath("//button[@class='button-1 new-address-next-step-button']");
    private final By shippingMethodRadioButton = By.id("shippingoption_0"); // there is a problem here.
    private final By continueShippingMethodButton = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    private final By paymentMethodRadioButton = By.xpath("//input[@id='paymentmethod_0']");
    private final By continuePaymentMethodButton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    private final By continuePaymentInfoButton = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    private final By confirmOrderButton = By.xpath("//button[normalize-space()='Confirm']");


    public void fillAddressDetailsData(String fName, String lName, String email, String country, String state, String city, String address1, String postalCode, String phone) {
//        webDriver.findElement(firstNameField).sendKeys(fName);
//        webDriver.findElement(lastNameField).sendKeys(lName);
//        webDriver.findElement(emailField).sendKeys(email);
        webDriver.findElement(cityField).sendKeys(city);
        webDriver.findElement(address1Field).sendKeys(address1);
        webDriver.findElement(postalCodeField).sendKeys(postalCode);
        webDriver.findElement(phoneField).sendKeys(phone);
        WebElement countryElement = webDriver.findElement(countryDropDown);
        Select countrySelect = new Select(countryElement);
        countrySelect.selectByVisibleText(country);
        WebElement stateElement = webDriver.findElement(stateDropDown);
        Select stateSelect = new Select(stateElement);
        stateSelect.selectByVisibleText(state);
        webDriver.findElement(continueAddressButton).click();
    }


    public void selectShippingMethod() throws InterruptedException {
        webDriver.findElement(shippingMethodRadioButton).click();
        webDriver.findElement(continueShippingMethodButton).click();
    }

    public void selectPaymentMethod(){
        webDriver.findElement(paymentMethodRadioButton).click();
        webDriver.findElement(continuePaymentMethodButton).click();
    }
    public void verifyPaymentInfo(){
        webDriver.findElement(continuePaymentInfoButton).click();
    }
    public void confirmOrder(){
        webDriver.findElement(confirmOrderButton).click();
    }

}
