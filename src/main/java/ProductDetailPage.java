import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends BasePage{

    String price ;
    By addToCartButtonLocator = By.id("pd_add_to_cart");
    By selectSizeButtonLocator = By.xpath("//*[@id=\"option-size\"]/a[3]");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }

    public void pickSize() {
        click(selectSizeButtonLocator);
    }


    public void pickPrice() {
        WebElement t=driver.findElement(By.xpath("//div[@class='basket-discount']"));
        String s = t.getText();
        price = s;
    }
}
