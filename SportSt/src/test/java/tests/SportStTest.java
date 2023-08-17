package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static util.Config.URL;

public class SportStTest extends BaseTest{
    @BeforeClass
    public void openSite(){
        basePage.open(URL);
    }
    @Test
    public void checkMainPage(){
        mainPage.assertThatPersonalAreaContainsCorrectText()
                .assertThatCountItemsAreCorrect()
                .assertThatCarouselContainsCorrectLink()
                .assertThatSelectedDefaultTabList()
                .clickLoadMoreButtonAndCheckChangeCountItems()
                .moveToElementAndAddToBusket()
                .increaseAndDecreaseCountItem()
                .inputSearchField("Forward APACHE");
    }
    @Test
    public void checkResultPage(){
        resultSearchPage.assertThatFoundCountItemsCorrect()
                .assertThatHeaderIsCorrect()
                .selectFirstItem();
    }
    @Test
    public void checkSelectItem(){
        bicyclePage.assertThatTypeBicycleIsCorrect()
                .assertThatSelectFirstImage()
                .clickOnButtonBuyInOneClick()
                .assertThatFieldContainsCorrectText()
                .clickOnSendButton()
                .assertThatFieldContainsAlert();
    }
}
