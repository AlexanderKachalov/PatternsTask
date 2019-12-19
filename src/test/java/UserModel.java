import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class UserModel {
    private UserModel() {}

    public static String getName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName().replace('ё', 'е');
    }

    public static String getPhone() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber().replaceAll("[()\\-]", "");
    }

    public static String getCity() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.address().city().replace('ё', 'е');
    }
}
