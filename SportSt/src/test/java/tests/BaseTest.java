package tests;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.BicyclePage;
import pages.MainPage;
import pages.ResultSearchPage;

import static util.DriverFactory.createWebDriver;

public class BaseTest {
    protected WebDriver driver = createWebDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MainPage mainPage = new MainPage(driver);
    protected ResultSearchPage resultSearchPage = new ResultSearchPage(driver);
    protected BicyclePage bicyclePage = new BicyclePage(driver);


}
