package pages.practiceform;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.base.BasePage;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import static common.Config.COUNT_STUDENT_FORM;

public class PracticeForm extends BasePage {
    public PracticeForm(WebDriver driver) {
        super(driver);
    }

    private final By practiceForm = By.xpath("//span[text() = 'Practice Form']");
    private final By countStudentFrom = By.cssSelector(".mt-2.row");

    private final By firstNameSelector = By.cssSelector("#firstName");
    private final By secondNameSelector = By.cssSelector("#lastName");

    private final By emailLocator = By.id("userEmail");

    private final By genderLocatorMale = By.xpath("//div[@class = 'custom-control custom-radio custom-control-inline'][1]");
    private final By genderLocatorFemale = By.xpath("//div[@class = 'custom-control custom-radio custom-control-inline'][2]");
    private final By genderLocatorOther = By.xpath("//div[@class = 'custom-control custom-radio custom-control-inline'][3]");

    private final By mobileSelector = By.id("userNumber");

    private final By dateOfBirthSelector = By.id("dateOfBirthInput");
    private final By yearSelector = By.xpath("//select[@class = 'react-datepicker__year-select']");
    private final By monthSelector = By.cssSelector(".react-datepicker__month-select");

    private final By subjectSelector = By.cssSelector("#subjectsInput");

    private final By hobby1Selector = By.xpath("//div[@class = 'custom-control custom-checkbox custom-control-inline'][1]");
    private final By hobby2Selector = By.xpath("//div[@class = 'custom-control custom-checkbox custom-control-inline'][2]");
    private final By hobby3Selector = By.xpath("//div[@class = 'custom-control custom-checkbox custom-control-inline'][3]");

    private final By addPictureSelector = By.cssSelector("#uploadPicture");

    private final By currentAddressLocator = By.xpath("//textarea[@placeholder = 'Current Address']");
    private final By selectStateSelector = By.cssSelector("#react-select-3-input");
    private final By selectCitySelector = By.cssSelector("#react-select-4-input");

    private final By submitSelector = By.cssSelector("#submit");

    private final By elementsTableSelector = By.cssSelector("table.table.table-dark tbody tr");
    private final By headerTableSelector = By.cssSelector(".modal-header");

    public PracticeForm clickToPracticeForm() {
        driver.findElement(practiceForm).click();
        return this;
    }

    public PracticeForm checkCountStudentForm() {
        int count = driver.findElements(countStudentFrom).size();
        Assert.assertEquals(count, COUNT_STUDENT_FORM);
        return this;
    }

    public PracticeForm insertFirstName(String firstName) {
        WebElement firstNameElement = driver.findElement(firstNameSelector);

        firstNameElement.sendKeys(firstName);
        return this;
    }

    public PracticeForm insertLastName(String lastName) {
        WebElement lastNameElement = driver.findElement(secondNameSelector);
        lastNameElement.sendKeys(lastName);
        return this;
    }

    public PracticeForm insertEmail(String email) {
        WebElement emailElement = driver.findElement(emailLocator);
        emailElement.sendKeys(email);
        return this;
    }

    public PracticeForm insertGender(String gender) {
        if (gender.equals("male")) {
            WebElement genderEl = driver.findElement(genderLocatorMale);
            genderEl.click();
        } else if (gender.equals("female")) {
            WebElement genderEl = driver.findElement(genderLocatorFemale);
            genderEl.click();
        } else driver.findElement(genderLocatorOther).click();
        return this;
    }

    public PracticeForm insertMobile(String mobile) {
        WebElement element = driver.findElement(mobileSelector);
        element.sendKeys(mobile);
        return this;
    }

    public PracticeForm setDateOfBirth(LocalDate date) {
        driver.findElement(dateOfBirthSelector).click();
        driver.findElement(yearSelector).click();
        By numberOfYear = By.xpath("//option[@value = '" + date.getYear() + "']");
        driver.findElement(numberOfYear).click();
        driver.findElement(monthSelector).click();
        By numberOfMonth = By.xpath("//select[@class = 'react-datepicker__month-select']/option[@value = '" + date.getMonth().getValue() + "']");
        driver.findElement(numberOfMonth).click();
        By numberOfDay = By.xpath("//div[@class = 'react-datepicker__month']//div[text() = '" + date.getDayOfMonth() + "']");
        driver.findElement(numberOfDay).click();
        return this;
    }

    public PracticeForm insertSubject(String subject) {
        WebElement element = driver.findElement(subjectSelector);
        element.click();
        element.sendKeys(subject);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeForm selectHobbies(boolean sport, boolean reading, boolean music) {
        if (sport == true) {
            driver.findElement(hobby1Selector).click();
        }
        if (reading == true) {
            driver.findElement(hobby2Selector).click();
        }
        if (music == true) {
            driver.findElement(hobby3Selector).click();
        }
        return this;
    }

    public PracticeForm addPicture(File filePath) {
        WebElement element = driver.findElement(addPictureSelector);
        element.sendKeys(filePath.getPath());
        return this;
    }

    public PracticeForm writeCurrentAddress(String address) {
        WebElement element = driver.findElement(currentAddressLocator);
        element.click();
        element.sendKeys(address);
        return this;
    }

    public PracticeForm selectState(String state) {
        WebElement element = waitElementIsVisible(driver.findElement(selectStateSelector));
        element.sendKeys(state);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeForm selectCity(String city) {
        WebElement element = waitElementIsVisible(driver.findElement(selectCitySelector));
        element.sendKeys(city);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeForm deleteFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByTagName('footer')[0].remove();");
        return this;
    }

    public PracticeForm clickSubmit() {
        WebElement element = waitElementIsVisible(driver.findElement(submitSelector));
        element.click();
        return this;
    }

    public PracticeForm getResultForms() {
        List<WebElement> elementsTable = driver.findElements(elementsTableSelector);
        int countResultForms = elementsTable.size();
        Assert.assertEquals(countResultForms, 10);
        WebElement headerTable = driver.findElement(headerTableSelector);
        Assert.assertEquals(headerTable.getText(), "Thanks for submitting the form");
        return this;
    }

}
