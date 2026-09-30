package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private static final String BASE_URL =
            "https://qa-desk.education-services.ru/";

    public void openMainPage() {
        open(BASE_URL);
    }

    public void openRegistrationPage() {
        openMainPage();

        $x("//button[contains(., 'Вход и регистрация')]")
                .shouldBe(visible)
                .click();

        $x("//*[contains(text(), 'Нет аккаунта')]")
                .shouldBe(visible)
                .click();
    }

    public void openLoginPage() {
        openMainPage();

        $x("//button[contains(., 'Вход и регистрация')]")
                .shouldBe(visible)
                .click();
    }

    public void openCreateListingPage() {
        $x("//button[contains(., 'Разместить объявление')]")
                .shouldBe(visible)
                .click();
    }

    public void shouldBeAuthorized() {
        $x("//*[normalize-space(text())='Выйти']")
                .shouldBe(visible);
    }

    public void searchListing(String title) {
        openMainPage();

        $x("//input[@placeholder='Я хочу купить...']")
                .shouldBe(visible)
                .setValue(title)
                .pressEnter();
    }

    public void shouldSeeListing(String title) {
        searchListing(title);

        listingTitle(title)
                .shouldBe(visible);
    }

    public void openListing(String title) {
        searchListing(title);

        listingTitle(title)
                .shouldBe(visible)
                .click();
    }

    public void shouldNotSeeListing(String title) {
        searchListing(title);

        listingTitle(title)
                .shouldNot(exist);
    }

    private com.codeborne.selenide.SelenideElement listingTitle(String title) {
        return $x("//div[contains(@class,'card')]//h2[normalize-space(.)="
                + xpathLiteral(title) + "]");
    }

    private String xpathLiteral(String text) {
        if (!text.contains("'")) {
            return "'" + text + "'";
        }

        if (!text.contains("\"")) {
            return "\"" + text + "\"";
        }

        String[] parts = text.split("'");
        StringBuilder result = new StringBuilder("concat(");

        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                result.append(", \"'\", ");
            }

            result.append("'")
                    .append(parts[i])
                    .append("'");
        }

        result.append(")");

        return result.toString();
    }
}