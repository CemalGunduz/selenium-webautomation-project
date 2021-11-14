import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;



public class SearchBox extends BasePage{

    By searchBoxLocator = By.id("search_input");
    By searchLocator = By.id("search_input");
   // By submitButtonLocator = By.xpath("//*[@id=\"header__container\"]/div/div/div/div[1]/div[2]/button");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        click(searchBoxLocator);
        searchType(searchLocator,text);
        //click(submitButtonLocator);

    }

}
