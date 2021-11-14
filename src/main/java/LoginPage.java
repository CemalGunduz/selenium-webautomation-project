import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    By mail = By.id("LoginEmail");
    By password = By.id("Password");
    By login = By.id("loginLink");


    public void setMail(String mailAddress){
        type(mail, mailAddress);

    }

    public void setPassword(String accPassword){
        type(password,accPassword);
    }

    public void clickLogin(){
        click(login);
    }


}
