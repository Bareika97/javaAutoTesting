package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static util.Config.URL;

public class MainPage extends BasePage {
    @FindBy(css = "span.auth_top__text")
    WebElement personalArea;

    @FindBy(css = "div.catalog_items.row article")
    List<WebElement> catalogItems;
    @FindBy(css = "a.carousel__item[href*='salomon']")
    WebElement salomonHref;
    @FindBy(xpath = "//div[@class = 'row clearfix']//ul[@role = 'tablist']/*")
    WebElement tabListAll;
    @FindBy(xpath = "//a[contains(text(), 'Загрузить ещё')]")
    WebElement loadMoreButton;
    @FindBy(css = "article:nth-child(1)")
    WebElement firstItemInCatalog;
    @FindBy(css = "button.catalog_item__btn")
    WebElement busketButton;
    @FindBy(xpath = "//i[@class = 'quantity__plus js-basket-plus']")
    WebElement increaseItem;
    @FindBy(xpath = "//i[@class = 'quantity__minus js-basket-minus']")
    WebElement decreaseItem;
    @FindBy(css = "input.search__input")
    WebElement searchField;

    public MainPage(WebDriver driver) {

        super(driver);
    }

    public MainPage assertThatPersonalAreaContainsCorrectText() {
        Assert.assertEquals(personalArea.getText(), "Личный кабинет");
        return this;
    }

    public MainPage assertThatCountItemsAreCorrect() {
        Assert.assertEquals(catalogItems.size(), 16);
        return this;
    }

    public MainPage assertThatCarouselContainsCorrectLink() {
        Assert.assertEquals(salomonHref.getAttribute("href"), URL + "brands/salomon_sports/");
        return this;
    }

    public MainPage assertThatSelectedDefaultTabList() {
        // Значение active отображается над той кнопкой, которая выбрана на данный момент
        Assert.assertEquals(tabListAll.getAttribute("class"), "active");
        return this;
    }

    public MainPage clickLoadMoreButtonAndCheckChangeCountItems() {
        loadMoreButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(catalogItems.size(), 32);
        return this;
    }
    public MainPage moveToElementAndAddToBusket(){
        Actions actions = new Actions(driver);
        actions.moveToElement(firstItemInCatalog).perform();
        busketButton.click();
        return this;
    }
    public MainPage increaseAndDecreaseCountItem(){
        Actions actions = new Actions(driver);
        actions.doubleClick(increaseItem).perform();
        decreaseItem.click();
        return this;
    }
    public MainPage inputSearchField(String itemName){
        searchField.sendKeys(itemName);
        searchField.sendKeys(Keys.RETURN);
        return this;
    }

}
