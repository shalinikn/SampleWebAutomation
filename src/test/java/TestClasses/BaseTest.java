package TestClasses;

import PageClasses.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * BaseTest class sets up and tears down the WebDriver environment for test execution.
 * It initializes the WebDriver, navigates to the target URL, and ensures proper cleanup after tests.
 */
public class BaseTest {

    protected WebDriver driver; // WebDriver instance
    protected HomePage homePage; // HomePage instance

    /**
     * Setup method to initialize WebDriver and navigate to the target application.
     * This method runs once before any test method in the class.
     */
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup(); // Set up WebDriverManager for Chrome
        driver = new ChromeDriver(); // Initialize ChromeDriver
        driver.manage().window().maximize(); // Maximize the browser window
        driver.get("https://todomvc.com/examples/react/dist/"); // Navigate to the TodoMVC application
        homePage = new HomePage(driver); // Initialize HomePage object
    }

    /**
     * Tear-down method to close the WebDriver instance after test execution.
     * This method runs once after all test methods in the class are executed.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser and clean up resources after the tests are complete
        }
    }
}
