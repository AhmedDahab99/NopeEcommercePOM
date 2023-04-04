import org.testng.annotations.Test;

public class TestCases extends TestBase {

    protected RegisterPage registerPageObject;
    protected AccountCreatedPage accountCreatedPageObject;
    protected LoginPage loginPageObject;

    @Test
    public void verifyThatUserCanOpenRegisterPage() {
        registerPageObject = homePageObject.openRegisterPage();
    }

    @Test
    public void verifyUserCanRegisterNewAccount() {
        accountCreatedPageObject = registerPageObject.fillUserData(
                "Ahmed", "Omar", "ahmedom@gmail.net", "12345678", "12345678", "tech", "1999", "June", "1"
        );
    }
//    @Test
//    public void verifyAccountCreatedSuccessfullyAndNavigateToHome(){
//        /*loginPageObject = */accountCreatedPageObject.verifyAccountCreatedSuccessfullyAndNavigateToHome();
////        loginPageObject.verifyOpeningLoginPage();
//    }

//    @Test
//    public void verifyUserCanLogin() {
//        loginPageObject.verifyUserCanLogin("ahmedom11@gmail.net","12345678");
//    }
}
