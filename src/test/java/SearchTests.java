import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchTests extends BaseTest {

    SearchBox searchBox;
    BasePage basePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;




    @Test
    @Order(1)
    public void searchProduct(){
        basePage = new BasePage(driver);
        productsPage = new ProductsPage(driver);
        searchBox = new SearchBox(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        searchBox.search("pantolan");
        Assertions.assertTrue(productsPage.isOnProductPage(),"Not on products page!");
        System.out.println("Search is accomplished.");
    }

    @Test
    @Order(2)
    public void scrollPageDown(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        productsPage.scrollDown();
        System.out.println("Page scrolled down.");
    }

    @Test
    @Order(3)
    public void seeMoreProduct(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        productsPage.clickSeeMoreProduct();
        System.out.println("Clicked see more product.");
    }

    @Test
    @Order(4)
    public void selectProduct(){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectedProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Not on product detail page!");
        System.out.println("Product selected.");
    }



    @Test
    @Order(5)
    public void addProductToCart(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        productDetailPage.pickSize();
        productDetailPage.pickPrice();
        productDetailPage.addToCart();
        System.out.println("Size selected and added into the cart.");
    }

    @Test
    @Order(6)
    public void goToCart(){
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        cartPage = new CartPage(driver);
        basePage.goToCartPage();
        System.out.println("Cart Page opened.");
    }

    @Test
    @Order(7)
    public void comparePrices(){
        Assertions.assertTrue(cartPage.isPricesMatched(),"Prices are not match!");
        System.out.println("Prices matched.");
    }

    @Test
    @Order(8)
    public void countingUpProduct(){
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        cartPage.countedUpProduct();
        Assertions.assertTrue(cartPage.isProductCountUp(),"Product count did nor increased!");
        cartPage.getNumberOfProduct();
        System.out.println("Added one more product into the cart.");
    }

    /* @Test
    @Order(8)
    public void emptyTheCart(){
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        cartPage.countDownProduct();

    }*/




}
