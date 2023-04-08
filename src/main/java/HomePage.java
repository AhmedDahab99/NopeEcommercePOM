import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
    protected WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    private By selectCategory = By.xpath("//a[@href='/computers']");
    private By selectedCategoryItem = By.xpath("//a[@href='/desktops']");
    private By addToCartButton = By.xpath("(//button[text()='Add to cart'])[2]");
    private By closeButton = By.className("close");
    private By cartLabel = By.className("cart-label");
    private By goToCartButton = By.xpath("//button[@class='button-1 cart-button']");

    public void setSelectedCategoryItem(){
        // hover on category
        WebElement categoryItem = webDriver.findElement(selectCategory);
        Actions action = new Actions(webDriver);
        action.moveToElement(categoryItem).perform();
        // select category
        webDriver.findElement(selectedCategoryItem).click();
    }

    public void setAddToCartButton(){
        webDriver.findElement(addToCartButton).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.findElement(closeButton).click();
    }

    public void navigateToShoppingCartPage(){
        WebElement cartLabelElement = webDriver.findElement(cartLabel);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(cartLabelElement).perform();
        webDriver.findElement(goToCartButton).click();
    }
}
