package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ResultSearchPage extends BasePage {
    @FindBy(css = "div.catalog_items article")
    List<WebElement> itemsFound;
    @FindBy(css = "h1.webpage__title")
    WebElement searchHeader;
    @FindBy(css = "div.catalog_item__inner")
    WebElement firstItem;

    public ResultSearchPage(WebDriver driver) {
        super(driver);
    }

    public ResultSearchPage assertThatFoundCountItemsCorrect() {
        Assert.assertTrue(itemsFound.size() == 6);
        return this;
    }
    public ResultSearchPage assertThatHeaderIsCorrect(){
        Assert.assertEquals(searchHeader.getText(), "Поиск");
        return this;
    }
    public ResultSearchPage selectFirstItem(){
        firstItem.click();
        return this;
    }

}
