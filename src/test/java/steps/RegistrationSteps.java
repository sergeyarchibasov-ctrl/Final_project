package steps;

import api.UserApi;
import context.TestContext;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.MainPage;
import pages.RegistrationPage;
import utils.TestDataGenerator;

public class RegistrationSteps {

    private final TestContext context;
    private final MainPage mainPage = new MainPage();
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final UserApi userApi = new UserApi();

    public RegistrationSteps(TestContext context) {
        this.context = context;
    }

    @Допустим("пользователь находится на странице регистрации")
    public void userIsOnRegistrationPage() {
        mainPage.openRegistrationPage();
    }

    @Когда("пользователь регистрируется с уникальными данными")
    public void userRegistersWithUniqueData() {
        context.setUser(TestDataGenerator.generateUser());
        registrationPage.register(context.getUser());
    }

    @Тогда("пользователь успешно авторизован")
    public void userIsSuccessfullyAuthorized() {
        mainPage.shouldBeAuthorized();
    }

    @Допустим("пользователь с такими данными уже зарегистрирован")
    public void existingUserIsRegistered() {
        context.setUser(TestDataGenerator.generateUser());
        userApi.createUser(context.getUser());
    }

    @Когда("пользователь пытается зарегистрироваться с теми же данными")
    public void userTriesToRegisterAgain() {
        registrationPage.register(context.getUser());
    }

    @Тогда("отображается ошибка регистрации")
    public void registrationErrorIsDisplayed() {
        registrationPage.shouldShowRegistrationError();
    }
}