import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends TestBase {

    protected RegisterPage registerPageObject = new RegisterPage(driver);
    protected LoginPage loginPageObj = new LoginPage(driver);
    protected HomePage  homePageObj = new HomePage(driver);
    public String email ="qqq@gm.com";
    public String password ="12345678";
    public String confirmPassword ="12345678";
    public String firstName ="Ahmed";
    public String lastName ="Omar";
    public String company ="Tech";
    public String birthYear ="1999";
    public String birthMonth ="June";
    public String birthDay ="1";

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
        String logoutVisible = driver.findElement(logoutText).getText();
        Assert.assertEquals(logoutVisible, "Log out");
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
        homePageObj.navigateToShoppingCartPage();
    }
}
