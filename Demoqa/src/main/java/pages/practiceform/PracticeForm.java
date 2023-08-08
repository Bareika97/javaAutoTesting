package pages.practiceform;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    By practiceForm = By.xpath("//span[text() = 'Practice Form']");
    By countStudentFrom = By.cssSelector(".mt-2.row");

    By firstNameSelector = By.cssSelector("#firstName");
    By secondNameSelector = By.cssSelector("#lastName");

    By emailLocator = By.id("userEmail");

    By genderLocatorMale = By.xpath("//div[@class = 'custom-control custom-radio custom-control-inline'][1]");
    By genderLocatorFemale = By.xpath("//div[@class = 'custom-control custom-radio custom-control-inline'][2]");
    By genderLocatorOther = By.xpath("//div[@class = 'custom-control custom-radio custom-control-inline'][3]");

    By mobileSelector = By.id("userNumber");

    By dateOfBirthSelector = By.id("dateOfBirthInput");
    By yearSelector = By.xpath("//select[@class = 'react-datepicker__year-select']");
    By monthSelector = By.cssSelector(".react-datepicker__month-select");

    By subjectSelector = By.cssSelector("#subjectsInput");

    By hobby1Selector = By.xpath("//div[@class = 'custom-control custom-checkbox custom-control-inline'][1]");
    By hobby2Selector = By.xpath("//div[@class = 'custom-control custom-checkbox custom-control-inline'][2]");
    By hobby3Selector = By.xpath("//div[@class = 'custom-control custom-checkbox custom-control-inline'][3]");

    By addPictureSelector = By.cssSelector("#uploadPicture");

    By currentAddressLocator = By.xpath("//textarea[@placeholder = 'Current Address']");
    By selectStateSelector = By.cssSelector("#react-select-3-input");
    By selectCitySelector = By.cssSelector("#react-select-4-input");

    By submitSelector = By.cssSelector("#submit");

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = driver.findElement(selectStateSelector);
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(state);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeForm selectCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = driver.findElement(selectCitySelector);

        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(city);

        element.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeForm deleteFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByTagName('footer')[0].remove();");
        return this;
    }

    public PracticeForm clickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = driver.findElement(submitSelector);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return this;
    }
    public PracticeForm getResultForms(){
        List elements = driver.findElements(By.xpath("//table[@class = 'table table-dark table-striped table-bordered table-hover']//tbody/tr"));
        int countResultForms = elements.size();
        Assert.assertEquals(countResultForms, 10);

        return this;
    }
    public void closeAllWindow(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
