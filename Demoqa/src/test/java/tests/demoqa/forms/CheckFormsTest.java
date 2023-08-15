package tests.demoqa.forms;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.io.File;
import java.time.LocalDate;

import static common.Config.PATH;
import static randomdata.RandomData.*;


public class CheckFormsTest extends BaseTest {
    @BeforeClass
    public void openForms(){
        basePage.open("https://demoqa.com/");
        startPage.clickToForms();
    }
//    @AfterClass
//    public void closeAllWindow() {
//        driver.quit();
//    }

    @Test
    public void fillForms() {
        createStateAndCites();
        File file = new File(PATH);
        practiceForm.clickToPracticeForm().checkCountStudentForm()
                .insertFirstName("Иван").insertLastName("Иванов").
                insertEmail("testtest@mail.ru").insertGender("123")
                .insertMobile("7909104474").setDateOfBirth(LocalDate.of(1997, 10, 28))
                .insertSubject(generateSubject()).selectHobbies(true, true, false)
                .addPicture(file).writeCurrentAddress("Улица Пушкина, дом Колотушкино").deleteFooter().
                selectState(generateRandomState()).selectCity(generateRandomCity()).clickSubmit()
                .getResultForms();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}


