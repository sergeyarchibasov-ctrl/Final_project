package utils;

import model.Listing;
import model.User;

import java.util.UUID;

public class TestDataGenerator {

    private static final String DEFAULT_PASSWORD = "Test123456";

    private TestDataGenerator() {
    }

    public static User generateUser() {
        String email = "test_"
                + UUID.randomUUID()
                + "@gmail.com";

        return new User(
                email,
                DEFAULT_PASSWORD
        );
    }

    public static Listing generateListing() {
        String uniquePart = UUID.randomUUID()
                .toString()
                .substring(0, 8);

        return new Listing(
                "Автотест " + uniquePart,
                "Авто",
                "Новый",
                "Москва",
                "Объявление создано автотестом",
                "10000"
        );
    }

    public static Listing generateUpdatedListing(Listing original) {
        String uniquePart = UUID.randomUUID()
                .toString()
                .substring(0, 8);

        return new Listing(
                "Автотест изменено " + uniquePart,
                original.getCategory(),
                original.getCondition(),
                original.getCity(),
                original.getDescription(),
                "15000"
        );
    }
}