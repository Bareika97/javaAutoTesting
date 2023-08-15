import org.junit.Test;

public class EdgeCenterTest extends BaseTest{
    EdgeCenter edgeCenter = new EdgeCenter();
    @Test
    public void testRun(){
        edgeCenter.clickButtonCompany().selectAboutCompany()
                .checkCountAchievementCards().assertThatResultContainsCorrectText().clickOnlyPermanentCookie()
                .clickAndSendName("Test").clickTelegram();
    }
}
