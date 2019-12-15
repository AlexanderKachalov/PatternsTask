import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestClass {
    private SelenideElement form;
    LocalDate date = LocalDate.now();
    int day = date.getDayOfMonth();

    @Test
    void testFormIfValidateAllInputData() {
        openForm();
        inputValidData();
        form.$("[data-test-id=agreement]").click();
        form.$$("button").find(exactText("Запланировать")).click();
        $("[data-test-id=success-notification]").shouldBe(visible);
        $(By.xpath("//*[@id='root']/div/div[1]/button")).click();
        inputOtherData();
        form.$$("button").find(exactText("Запланировать")).click();
        $("[data-test-id=replan-notification]").shouldBe(visible);
        form.$$("button").find(exactText("Перепланировать")).click();
        $("[data-test-id=success-notification]").shouldBe(visible);
    }

    private void openForm() {
        open("http://localhost:9999");
        form = $(By.className("App_appContainer__3jRx1"));
    }

    private void inputValidData() {
        Faker faker = new Faker(new Locale("ru"));
        String nameUser = faker.name().firstName();
        String phoneNumber = faker.phoneNumber().phoneNumber().replaceAll("[()\\-]", "");
        String cityName = faker.address().city();
        form.$("[data-test-id=city] input").setValue(cityName);
        form.$("[data-test-id=name] input").setValue(nameUser);
        form.$("[data-test-id=phone] input").setValue(phoneNumber);
        form.$("[data-test-id=date]").click();
        form.$(By.xpath("//*[text()='" + (day + 5) + "']")).click();
    }

    private void inputOtherData () {
        form.$("[data-test-id=date]").click();
        form.$(By.xpath("//*[text()='" + (day + 4) + "']")).click();
    }
}

