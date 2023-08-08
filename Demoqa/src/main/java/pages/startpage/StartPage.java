package pages.startpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class StartPage extends BasePage {

    public StartPage(WebDriver driver) {
        super(driver);
    }
    By categoryToForms = By.xpath("//h5[text() = 'Forms']");

    public StartPage clickToForms(){
        driver.findElement(categoryToForms).click();
        return this;
    }
}
