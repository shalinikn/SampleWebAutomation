package TestClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class contains the test cases for the HomePage functionality of the application.
 * It includes tests for navigating to the "ToDo" page, adding a new ToDo,
 * marking ToDo as complete, checking active ToDo, and clearing completed ToDos.
 */
public class HomePageTest extends BaseTest {
    private PageObjectManager pageObjectManager;

    /**
     * Initializes the PageObjectManager before each test method.
     * Ensures that the landing page is loaded before the tests are executed.
     */
    @BeforeMethod
    public void setUp() {
        pageObjectManager = new PageObjectManager(driver);
        // Ensuring the landing page is loaded before each test
        Assert.assertTrue(pageObjectManager.getHomePage().lanOnLandingPage(), "Failed to land on HomePage");
    }

    /**
     * Tests the navigation to the ToDo page.
     * Verifies that the user is successfully navigated to the landing page.
     */
    @Test(priority = 1)
    public void testNavigateToDoPage() {
        Assert.assertTrue(pageObjectManager.getHomePage().lanOnLandingPage(), "Landing page did not load as expected");
    }

    /**
     * Tests adding a new ToDo.
     * Verifies that the user can add a new ToDo and it appears in the ToDo list.
     */
    @Test(priority = 2)
    public void testAddingNewToDo() {
        pageObjectManager.getHomePage().sendToDo();
        pageObjectManager.getHomePage().validateSentToDo();
    }

    /**
     * Tests marking a ToDo as complete.
     * Verifies that a ToDo can be marked as complete and reflects the change in the ToDo list.
     */
    @Test(priority = 3)
    public void testMarkToDoComplete() {
        pageObjectManager.getHomePage().sendToDo();
        pageObjectManager.getHomePage().clickOnCompleted();
        pageObjectManager.getHomePage().validateCompletedToDo();
    }

    /**
     * Tests checking for active ToDos.
     * Verifies that the active ToDo list correctly shows only the active items.
     */
    @Test(priority = 4)
    public void testCheckActiveToDo() {
        pageObjectManager.getHomePage().sendToDo();
        pageObjectManager.getHomePage().clickOnActiveToDo();
        pageObjectManager.getHomePage().validateActiveToDo();
    }

    /**
     * Tests clearing a ToDo.
     * Verifies that a checked ToDo can be cleared from the list.
     */
    @Test(priority = 5)
    public void testClearToDo() {
        pageObjectManager.getHomePage().sendToDo();
        pageObjectManager.getHomePage().clickOnCheckBox();
        pageObjectManager.getHomePage().clickOnClearToDo();
        pageObjectManager.getHomePage().validateClearToDo();
    }
}
