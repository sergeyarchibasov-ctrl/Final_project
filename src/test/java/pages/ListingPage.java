package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ListingPage {

    public void openEditPage() {
        $x("//button[contains(., 'Редактировать объявление')]")
                .shouldBe(visible)
                .click();
    }

    public void deleteListing() {
        $x("//button[contains(., 'Удалить')]")
                .shouldBe(visible)
                .click();
    }
}