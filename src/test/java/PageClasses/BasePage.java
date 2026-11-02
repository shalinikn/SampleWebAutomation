package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage class serves as a foundation for all page classes.
 * It provides common WebDriver actions and utilities for handling web elements.
 */
public abstract class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor to initialize the BasePage with a WebDriver instance.
     *
     * @param driver the WebDriver instance used for interacting with the web page.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Default wait time
        PageFactory.initElements(driver, this);
    }

    /**
     * Waits for an element to be visible on the page.
     *
     * @param element the WebElement to wait for.
     * @return the WebElement after it becomes visible.
     */
    protected WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for an element to be clickable and clicks on it.
     *
     * @param element the WebElement to be clicked.
     */
    protected void clickElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    /**
     * Waits for an element to be visible, clears its existing content, and enters the specified text.
     * The method also simulates pressing the ENTER key after entering text.
     *
     * @param element the WebElement where text should be entered.
     * @param text    the text to be entered.
     */
    protected void enterText(WebElement element, String text) {
        waitForElementToBeVisible(element).clear();
        element.sendKeys(text, Keys.ENTER);
    }

    /**
     * Retrieves the visible text from a given WebElement.
     *
     * @param element the WebElement from which text should be retrieved.
     * @return the text content of the WebElement.
     */
    protected String getElementText(WebElement element) {
        return waitForElementToBeVisible(element).getText();
    }

    /**
     * Checks whether an element is visible multiple times within the given number of attempts.
     *
     * @param element the WebElement to check visibility for.
     * @param attempts the number of times to check for visibility.
     * @return true if the element is visible in all attempts; false otherwise.
     */
    protected boolean isElementVisibleMultipleTimes(WebElement element, int attempts) {
        for (int i = 0; i < attempts; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
            } catch (TimeoutException e) {
                return false; // If the element is not visible within the wait time, return false
            }
        }
        return true; // Returns true if the element was visible in all attempts
    }
}
