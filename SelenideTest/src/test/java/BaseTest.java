import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.$;

abstract public class BaseTest {
    @Before
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Selenide.open("https://edgecenter.ru/");
    }

    @After
    public void tearDown(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Selenide.closeWebDriver();
    }

}
