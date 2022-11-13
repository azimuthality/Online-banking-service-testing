import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;


public class BirgaTest extends LoginTest {

    public SelenideElement historyContainer = $(By.xpath("//a[@class='payment-menu-icon history']"));
    public SelenideElement searchField = $(By.xpath("//input[@name='search']"));



    @BeforeAll
    static void beforeConfig() {
        Configuration.timeout = 3000;
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void before() {
        open(baseUrl);
    }

    @Test()
    public void test() throws InterruptedException {

        step1();

        step2();

        step3();

        step4();

    }

    @Step("Поиск платежа в истории платежей")
    public void step4() {
        paymentsButton.should(Condition.visible).click();
        CheckText(historyContainer.getText(), "История");
        historyContainer.should(Condition.visible).click();
        searchField.should(Condition.visible).val("Билайн");
        searchField.should(Condition.visible).pressEnter();
    }

    @AfterEach
    public void after() {
    }
}

