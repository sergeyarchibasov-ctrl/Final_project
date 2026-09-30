package pages;

import model.User;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public void login(User user) {
        $("[name='email']")
                .setValue(user.getEmail());

        $("[name='password']")
                .setValue(user.getPassword());

        $x("//button[@type='submit' and normalize-space(.)='Войти']")
                .click();
    }
}