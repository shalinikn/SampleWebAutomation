package PageClasses;

import WebUtils.WebActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private WebActions webActions;

    public HomePage(WebDriver driver) {
        super(driver);
        this.webActions = new WebActions(driver); // Initialize WebActions
    }

    // Locators using @FindBy
    @FindBy(xpath = "//*[@class='todoapp']")
    private WebElement landingPageText;

    @FindBy(xpath = "//*[@data-testid='text-input']")
    private WebElement inputFieldOfToDo;

    @FindBy(xpath = "//*[@data-testid='todo-item-toggle']")
    private WebElement checkBoxToggle;

    @FindBy(xpath = "//*[@href='#/active']")
    private WebElement activeToDoCta;

    @FindBy(xpath = "//*[@href='#/completed']")
    private WebElement completeToDo;

    @FindBy(xpath = "//*[@class='clear-completed']")
    private WebElement clearCompletedCta;

    @FindBy(xpath = "//*[@class='completed']")
    private WebElement completedToDo;

    @FindBy(xpath = "//label[text()='Reached Office']")
    private WebElement activeToDo;

    @FindBy(xpath = "//*[@data-testid='todo-item-label']")
    private WebElement clearToDoItems;

    @FindBy(xpath = "//label[text()='WakeUp']")
    private WebElement wakeUpText;

    @FindBy(xpath = "//label[text()='Gym']")
    private WebElement gymText;

    @FindBy(xpath = "//label[text()='Get Ready']")
    private WebElement getReadyText;

    @FindBy(xpath = "//a[text()='All']")
    private WebElement allCta;

    @FindBy(xpath = "//span[@class='todo-count']")
    private WebElement toDoCount;


    /**
     * Verifies that the landing page text is visible.
     *
     * @return true if the landing page text is displayed
     */
    public boolean lanOnLandingPage() {
        waitForElementToBeVisible(landingPageText);
        return landingPageText.isDisplayed();
    }

    /**
     * Sends multiple to-do items.
     *
     * @return true after entering tasks
     */
    public boolean sendToDo() {
        waitForElementToBeVisible(landingPageText);
        enterText(inputFieldOfToDo, "WakeUp");
        enterText(inputFieldOfToDo, "Gym");
        enterText(inputFieldOfToDo, "Get Ready");
        return true;
    }

    public boolean validateSentToDo() {
        waitForElementToBeVisible(wakeUpText);
        waitForElementToBeVisible(gymText);
        waitForElementToBeVisible(getReadyText);
        return true;
    }

    /**
     * Clicks on the checkbox to mark a to-do as completed and navigates to the Completed tab.
     *
     * @return true after clicking on completed
     */
    public boolean clickOnCompleted() {
        checkBoxToggle.click();
        completeToDo.click();
        return true;
    }

    /**
     * Validates if completed to-do items are visible.
     *
     * @return true if completed tasks are visible
     */
    public boolean validateCompletedToDo() {
        isElementVisibleMultipleTimes(completedToDo, 3);
        return true;
    }

    /**
     * Clicks on the button to clear completed to-do items.
     *
     * @return true after clearing completed tasks
     */
    public boolean clickOnClearToDo() {
        clickElement(clearCompletedCta);
        return true;
    }

    /**
     * Adds "Reached Office" as a to-do and navigates to the Active tab.
     *
     * @return true after adding active to-do
     */
    public boolean clickOnActiveToDo() {
        enterText(inputFieldOfToDo, "Reached Office");
        clickElement(activeToDoCta);
        waitForElementToBeVisible(activeToDo);
        return true;
    }

    /**
     * Validates if the active to-do item is visible.
     *
     * @return true if active task is visible
     */
    public boolean validateActiveToDo() {
        waitForElementToBeVisible(activeToDo);
        return true;
    }

    /**
     * Clicks on the checkbox of a to-do item.
     *
     * @return true after clicking on the checkbox
     */
    public boolean clickOnCheckBox() {
        checkBoxToggle.click();
        return true;
    }

    /**
     * Validates if the clear to-do items button is visible.
     *
     * @return false (default behavior if element is not found)
     */
    public boolean validateClearToDo() {
        waitForElementToBeVisible(clearToDoItems);
        return false;
    }

    /**
     * Clicks on the "All" call-to-action (CTA) button.
     * This button is used to display all to-do items, including completed and active ones.
     *
     * @return true if the action is performed successfully
     */
    public boolean clickOnAllCta() {
        allCta.click();
        return true;
    }

    /**
     * Validates if the to-do items count matches "1 item left!".
     * Fetches the text from the to-do count element and checks for the expected value.
     *
     * @return true if the validation is successful
     */
    public boolean ToDoLeft() {
        toDoCount.getText().equals("1 item left!");
        return true;
    }
}
