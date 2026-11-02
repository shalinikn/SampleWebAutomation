package WebUtils;

import PageClasses.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * WebActions class provides reusable methods for advanced web interactions.
 */
public class WebActions extends BasePage {

    private Actions actions;

    /**
     * Constructor for WebActions.
     *
     * @param driver WebDriver instance
     */
    public WebActions(WebDriver driver) {
        super(driver);
        this.actions = new Actions(driver); // Initialize Actions object
    }

    /**
     * Performs a mouse hover over the given WebElement.
     *
     * @param element WebElement to hover over
     */
    public void hoverOverElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    /**
     * Selects a value from a dropdown by visible text.
     *
     * @param dropdown WebElement representing the dropdown
     * @param value    Visible text of the option to select
     */
    public void selectDropdownByVisibleText(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    /**
     * Selects a value from a dropdown by index.
     *
     * @param dropdown WebElement representing the dropdown
     * @param index    Index of the option to select
     */
    public void selectDropdownByIndex(WebElement dropdown, int index) {
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    /**
     * Double clicks on the given WebElement.
     *
     * @param element WebElement to double click
     */
    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    /**
     * Right-clicks on the given WebElement.
     *
     * @param element WebElement to right-click
     */
    public void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }

    /**
     * Drags an element and drops it onto a target element.
     *
     * @param source WebElement to drag
     * @param target WebElement to drop onto
     */
    public void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }

    /**
     * Scrolls until the given WebElement is found.
     *
     * @param element WebElement to scroll to
     */
    public void scrollUntilElementClick(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        jsExecutor.executeScript("arguments[0].click();", element);

    }
}
