import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class FlipkartLinksTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
    }

    @Test(priority = 1)
    public void testCountLinksOnHomepage() {
        int count = driver.findElements(By.tagName("a")).size();
        System.out.println("Number of links on the homepage: " + count);
    }

    @Test(priority = 2)
    public void testPrintAllLinks() {
        for (WebElement link : driver.findElements(By.tagName("a"))) {
            String text = link.getText();
            String url = link.getAttribute("href");
            System.out.println(text + " - " + url);
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}