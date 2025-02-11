package TestClasses;

import PageClasses.HomePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;


@Getter
public class PageObjectManager {

    private final WebDriver driver;

    // Page objects for different modules
    private HomePage homePage;




    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
        initializePageObjects();
    }

    private void initializePageObjects() {
        homePage = new HomePage(driver);
    }


    public HomePage getHomePage() {
        return homePage;
    }


    }

