package tests.base;

import common.CommonAction;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.practiceform.PracticeForm;
import pages.startpage.StartPage;
import randomdata.RandomData;

public class BaseTest {
    protected WebDriver driver = CommonAction.createWebDriver();
    protected BasePage basePage = new BasePage(driver);
    protected StartPage startPage = new StartPage(driver);
    protected PracticeForm practiceForm = new PracticeForm(driver);
    protected RandomData randomData = new RandomData(driver);
}
