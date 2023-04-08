import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCases extends TestBase {

    protected RegisterPage registerPageObject = new RegisterPage(driver);
    protected LoginPage loginPageObj = new LoginPage(driver);
    protected HomePage  homePageObj = new HomePage(driver);
    protected ShoppingCartPage  shoppingCartObj = new ShoppingCartPage(driver);
    protected CheckoutPage  checkoutOBJ = new CheckoutPage(driver);
    public String email ="aa@gm.com";
    public String password ="12345678";
    public String confirmPassword ="12345678";
    public String firstName ="Ahmed";
    public String lastName ="Omar";
    public String company ="Tech";
    public String birthYear ="1999";
    public String birthMonth ="June";
    public String birthDay ="1";
    public String country ="United States";
    public String state ="Florida";
    public String city ="galaxy";
    public String address1 ="galaxy street";
    public String postalCode ="555";
    public String phone ="564654646";

    @Test
    public void verifyThatUserCanOpenRegisterPage() {
        registerPageObject = landingPageObject.openRegisterPage();
    }

    @Test(dependsOnMethods = {"verifyThatUserCanOpenRegisterPage"})
    public void verifyUserCanRegisterNewAccount() {
        registerPageObject.fillUserData(
                firstName, lastName, email, password,
                confirmPassword, company, birthYear, birthMonth, birthDay
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        By accountCreatedText = By.xpath("//div[text()='Your registration completed']");
        String accountCreated = driver.findElement(accountCreatedText).getText();
        Assert.assertEquals(accountCreated, "Your registration completed");
    }

    @Test(dependsOnMethods = {"verifyUserCanRegisterNewAccount"})
    public void verifyThatUserCanOpenLoginPage() {
        loginPageObj = landingPageObject.openLoginPage();
    }

    @Test(dependsOnMethods = {"verifyThatUserCanOpenLoginPage"})
    public void verifyUserCanLogin() {
        homePageObj = loginPageObj.verifyUserCanLogin(email, password);
        By logoutText = By.linkText("Log out");
        boolean logoutVisible = homePageObj.webDriver.findElement(logoutText).isDisplayed();
        Assert.assertTrue(logoutVisible);
    }

    @Test (dependsOnMethods = {"verifyUserCanLogin"})
    public void setSelectedCategoryItem(){
        homePageObj.setSelectedCategoryItem();
    }

    @Test (dependsOnMethods = {"setSelectedCategoryItem"})
    public void addProductToCart(){
        homePageObj.setAddToCartButton();
        String title = driver.findElement(By.className("content")).getText();
        System.out.println("Title is "+ title);
        Assert.assertEquals(title , "The product has been added to your shopping cart");
    }

    @Test (dependsOnMethods = {"addProductToCart"})
    public void navigateToShoppingCartPage(){
      shoppingCartObj = homePageObj.navigateToShoppingCartPage();
    }

//    @Test(dependsOnMethods = {"navigateToShoppingCartPage"})
//    public void updateProductQuantity(String quantity){
//        shoppingCartObj.updateProductQuantity(quantity);
//    }

    @Test (dependsOnMethods = {"navigateToShoppingCartPage"})
    public void doCheckout(){
        checkoutOBJ = shoppingCartObj.checkoutCart();
    }

    @Test (dependsOnMethods = {"doCheckout"})
    public void confirmOrder() throws InterruptedException {
        checkoutOBJ.fillAddressDetailsData(firstName,lastName,email,country,state,city,address1,postalCode,phone);
        checkoutOBJ.selectShippingMethod();
        checkoutOBJ.selectPaymentMethod();
        checkoutOBJ.verifyPaymentInfo();
        checkoutOBJ.confirmOrder();
    }

}
