import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    WebDriver driver;

    @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().window().maximize();
        System.out.println("Test initiated");

    }

    @BeforeEach
    public void delayTime(){
        driver.manage().timeouts().implicitlyWait(400, TimeUnit.MILLISECONDS);
    }


    @AfterAll
    public void shutDown(){
    driver.quit();
    System.out.println("Test finished.");
    }


}
