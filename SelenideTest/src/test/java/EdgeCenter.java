import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class EdgeCenter extends BaseTest {
    private SelenideElement mainText = $(".title.hero__title");
    private SelenideElement aboutCompany = $x("//a[text() = 'О компании']");
    private SelenideElement buttonCompany = $x("//span[text() = 'Компания']/..");
    private ElementsCollection achievementCards = $$(".achievement-cards__list.list-row._col-3 li");
    private SelenideElement onlyPermanentCookie = $("button.btn.elcookie__btn._light-gray");
    private SelenideElement fieldName = $("input.field-text__input[placeholder = 'Как Вас зовут?']");
    private SelenideElement telegramButton = $(".social.page-footer__social a.social__link[href = 'https://t.me/edgecenter']");

    public EdgeCenter clickButtonCompany() {
        buttonCompany.click();
        return this;
    }

    public EdgeCenter selectAboutCompany() {

        aboutCompany.click();
        Assert.assertEquals("Центр облачных и edge-решений", mainText.getText());
        return this;
    }

    public EdgeCenter checkCountAchievementCards() {
        achievementCards.shouldHave(CollectionCondition.size(6));
        return this;
    }

    public EdgeCenter clickOnlyPermanentCookie() {
        onlyPermanentCookie.click();
        return this;
    }

    public EdgeCenter assertThatResultContainsCorrectText() {
        $("li.list-col:nth-child(2) .achievement-card__title").shouldBe(Condition.innerText("Участник АРПП «Отечественный софт»"));
        $("li.list-col:nth-child(3) .achievement-card__title").shouldHave(Condition.innerText("Сколково"));
        return this;
    }

    public EdgeCenter clickAndSendName(String name) {
        fieldName.click();
        fieldName.sendKeys(name);
        return this;
    }

    public EdgeCenter clickTelegram() {
        telegramButton.click();
        return this;
    }
}
