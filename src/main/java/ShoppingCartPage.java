import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    protected WebDriver webDriver;

    public  ShoppingCartPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private  final By quantityInput = By.id("itemquantity11265");
    private  final By termsAgreementCheckBox = By.id("termsofservice");
    private  final By checkoutButton = By.id("checkout");

    public void updateProductQuantity(String qty){
        webDriver.findElement(quantityInput).sendKeys(qty);
    }

    public CheckoutPage checkoutCart(){
        webDriver.findElement(termsAgreementCheckBox).click();
        webDriver.findElement(checkoutButton).click();
        return new CheckoutPage(webDriver);
    }

}
