import org.testng.annotations.Test;

public class TestCases extends TestBase {

    protected RegisterPage registerPageObject;

    @Test
    public void verifyThatUserCanOpenRegisterPage() {
        registerPageObject = homePageObject.openRegisterPage();
    }

    @Test
    public void verifyUserCanRegisterNewAccount() {
     registerPageObject.fillUserData(
                "Ahmed", "Omar", "ahmedom@gmail.net", "12345678", "12345678", "tech", "1999", "June", "1"
        );
    }
}
