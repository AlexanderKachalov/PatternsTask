import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestClass {
    private SelenideElement form;


    @Test
    void testFormIfValidateAllInputData() {
        openForm();
        inputValidData();
        inputDay(10);
        $("[data-test-id=success-notification]").shouldBe(visible);
    }

    private void openForm() {
        open("http://localhost:9999");
        form = $(By.className("App_appContainer__3jRx1"));
    }

    private void inputValidData() {
        form.$("[data-test-id=city] input").setValue(UserModel.getCity());
        form.$("[data-test-id=name] input").setValue(UserModel.getName());
        form.$("[data-test-id=phone] input").setValue(UserModel.getPhone());
        form.$("[data-test-id=agreement]").click();
    }

    private void inputDay(int plusDay) {
        form.$$("button").find(exactText("Запланировать")).click();
        $("[data-test-id=success-notification]").shouldBe(visible);
        $(By.xpath("//*[@id='root']/div/div[1]/button")).click();
        LocalDate otherDay = LocalDate.now().plusDays(plusDay);
        String futureDay = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(otherDay);
        form.$("[placeholder='Дата встречи']").sendKeys("\b\b\b\b\b\b\b\b\b\b");
        form.$("[placeholder='Дата встречи']").setValue(futureDay).click();
        form.$$("button").find(exactText("Запланировать")).click();
        $("[data-test-id=replan-notification]").shouldBe(visible);
        form.$$("button").find(exactText("Перепланировать")).click();
    }
}

