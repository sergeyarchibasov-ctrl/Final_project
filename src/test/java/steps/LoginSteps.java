package steps;

import api.UserApi;
import context.TestContext;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.LoginPage;
import pages.MainPage;
import utils.TestDataGenerator;

public class LoginSteps {

    private final TestContext context;
    private final MainPage mainPage = new MainPage();
    private final LoginPage loginPage = new LoginPage();
    private final UserApi userApi = new UserApi();

    public LoginSteps(TestContext context) {
        this.context = context;
    }

    @Допустим("зарегистрированный пользователь существует")
    public void registeredUserExists() {
        context.setUser(TestDataGenerator.generateUser());
        userApi.createUser(context.getUser());
    }

    @Допустим("пользователь находится на странице входа")
    public void userIsOnLoginPage() {
        mainPage.openLoginPage();
    }

    @Когда("пользователь вводит корректные данные для входа")
    public void userEntersCorrectLoginData() {
        loginPage.login(context.getUser());
    }

    @Тогда("пользователь успешно авторизован после входа")
    public void userIsAuthorizedAfterLogin() {
        mainPage.shouldBeAuthorized();
    }
}