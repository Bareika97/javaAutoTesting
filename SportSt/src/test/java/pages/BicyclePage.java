package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BicyclePage extends BasePage{
    @FindBy(css = "[data-code = 'SKY_TYPE_BIKE'] li.offer_prop__value")
    WebElement typeBicycle;
    @FindBy(css = "button.owl-dot")
    WebElement firstImage;
    @FindBy(css = "a[title = 'Купить в 1 клик']")
    WebElement buttonBuyInOneClick;
    @FindBy(css = "#captcha_")
    WebElement captcha;
    @FindBy(css = ".row input.btn.btn-primary")
    WebElement sendButtonInFormBuy;
    @FindBy(css = ".alert.alert-danger")
    WebElement alert;
    public BicyclePage(WebDriver driver) {
        super(driver);
    }
    public BicyclePage assertThatTypeBicycleIsCorrect(){
        Assert.assertEquals(typeBicycle.getText(), "Хардтейл");
        return this;
    }
    public BicyclePage assertThatSelectFirstImage(){
        // выбранный элемент в своем классе содержит слово "active"
       Assert.assertTrue(firstImage.getAttribute("class").contains("active"));
        return this;
    }
    public BicyclePage clickOnButtonBuyInOneClick(){
        buttonBuyInOneClick.click();
        return this;
    }
    public BicyclePage assertThatFieldContainsCorrectText(){
        Assert.assertEquals(captcha.getAttribute("placeholder"), "Введите код с картинки*");
        return this;
    }
    public BicyclePage clickOnSendButton(){
        sendButtonInFormBuy.click();
        return this;
    }
    public BicyclePage assertThatFieldContainsAlert(){
        Assert.assertEquals(alert.getText(), "Неверно введен код защиты");
        return this;
    }
}
