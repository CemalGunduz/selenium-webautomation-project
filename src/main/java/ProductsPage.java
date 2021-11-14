import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    By feedBackOptionLocator = By.id("category-breadcrumb");
    By loadMoreButtonLocator = By.id("pageIndex");
    By productNameLocator = By.className("a_model_item");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(feedBackOptionLocator);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void clickSeeMoreProduct() {
        click(loadMoreButtonLocator);
    }

    public void selectedProduct(int i) {
        getAllProducts().get(i).click();
    }

    protected List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }

}
