package pages;

import model.User;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    public void register(User user) {
        $("[name='email']")
                .setValue(user.getEmail());

        $("[name='password']")
                .setValue(user.getPassword());

        $("[name='submitPassword']")
                .setValue(user.getPassword());

        $x("//button[@type='submit' and normalize-space(.)='Создать аккаунт']")
                .click();
    }

    public void shouldShowRegistrationError() {
        $x("//*[normalize-space(text())='Ошибка']")
                .shouldBe(visible);
    }
}