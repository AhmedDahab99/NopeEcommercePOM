import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    protected WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    private By addToCartButton = By.xpath("//button[@class='button-2 product-box-add-to-cart-button']");

    public void addProductToCart(){
        webDriver.findElement(addToCartButton).click();
    }
}
