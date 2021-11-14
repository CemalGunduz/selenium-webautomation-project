import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class CartPage extends BasePage {

    ProductDetailPage productDetailPage;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String itemIdCracker() {
        WebElement t = driver.findElement(By.xpath("//div[@class='rd-cart-item shoppingcart-item']"));
        String itemId = t.getAttribute("cartitemid");
        return itemId;
    }

    public void countedUpProduct() {
        By plusSymbol = By.id("Cart_AddQuantity_" + itemIdCracker());
        click(plusSymbol);
    }

    public boolean isProductCountUp() {
        return getCartCount() > 0;
    }

    public void getNumberOfProduct() {
        String numberOfProduct = find(cartCountLocator).getText();
        Integer.parseInt(numberOfProduct);
    }

    public void countDownProduct() {
        By trashSymbol = By.id("Cart_ProductDelete_" + itemIdCracker());
        click(trashSymbol);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String fullId = "Cart_ProductDelete_" + itemIdCracker();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementById(fullId).click();");

    }

    public boolean isPricesMatched() {
        WebElement t=driver.findElement(By.xpath("//span[@class='rd-cart-item-price mb-15']"));
        String s = t.getText();
        productDetailPage = new ProductDetailPage(driver);
       return productDetailPage.price == s ;
    }
}
