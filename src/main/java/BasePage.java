import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class BasePage {

    WebDriver driver;

    By cartCountLocator = By.id("spanCart");
    By cartContainerLocator = By.xpath("/html/body/div[5]/div[2]/div[1]/div[4]/div/div[4]/a");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void type(By locator, String text){
        find(locator).sendKeys(text);
    }

    public void searchType(By locator, String text){
        find(locator).sendKeys(text, Keys.ENTER);
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public void goToCartPage() {
        click(cartContainerLocator);
    }

    protected int getCartCount(){
       String count = find(cartCountLocator).getText();
       return Integer.parseInt(count);
    }

}
