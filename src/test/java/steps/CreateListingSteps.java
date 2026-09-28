package steps;

import api.UserApi;
import context.TestContext;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.CreateListingPage;
import pages.LoginPage;
import pages.MainPage;
import utils.TestDataGenerator;

public class CreateListingSteps {

    private final TestContext context;
    private final UserApi userApi = new UserApi();
    private final MainPage mainPage = new MainPage();
    private final LoginPage loginPage = new LoginPage();
    private final CreateListingPage createListingPage =
            new CreateListingPage();

    public CreateListingSteps(TestContext context) {
        this.context = context;
    }

    @Допустим("авторизованный пользователь находится на главной странице")
    public void authorizedUserIsOnMainPage() {
        context.setUser(TestDataGenerator.generateUser());

        userApi.createUser(context.getUser());

        mainPage.openLoginPage();

        loginPage.login(context.getUser());

        mainPage.shouldBeAuthorized();
    }

    @Когда("пользователь переходит к созданию объявления")
    public void userOpensCreateListingPage() {
        mainPage.openCreateListingPage();

        createListingPage.shouldBeOpened();
    }

    @И("пользователь заполняет и публикует новое объявление")
    public void userCreatesListing() {
        context.setListing(TestDataGenerator.generateListing());

        createListingPage.createListing(context.getListing());
    }

    @Тогда("новое объявление отображается на главной странице")
    public void listingIsDisplayedOnMainPage() {
        mainPage.shouldSeeListing(context.getListing().getName());
    }
}