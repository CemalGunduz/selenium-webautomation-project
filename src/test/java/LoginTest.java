import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends BaseTest {

    BasePage basePage;
    LoginPage loginPage;

    @Test
    @Order(0)
    public void setEnterLoginPage() throws InterruptedException {
        basePage = new BasePage(driver);
        basePage.click((By.xpath("//a[@href=\"https://www.lcwaikiki.com/tr-TR/TR/giris\"]")));
        System.out.println("Entered login page.");
    }

    @Test
    @Order(1)
    public void setMail(){
        loginPage = new LoginPage(driver);
        loginPage.setMail("deneme@mail.com");
        System.out.println("Mail tested.");
    }

    @Test
    @Order(2)
    public void setPassword(){
        loginPage.setPassword("abcdefgh");
        System.out.println("Password tested.");
    }

    @Test
    @Order(3)
    public void setClickLogin(){
        loginPage.clickLogin();
        System.out.println("Login button tested.");
    }

}
