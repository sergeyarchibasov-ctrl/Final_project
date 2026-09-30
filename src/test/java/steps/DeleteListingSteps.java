package steps;

import api.UserApi;
import context.TestContext;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.CreateListingPage;
import pages.ListingPage;
import pages.LoginPage;
import pages.MainPage;
import utils.TestDataGenerator;

public class DeleteListingSteps {

    private final TestContext context;

    private final UserApi userApi = new UserApi();
    private final MainPage mainPage = new MainPage();
    private final LoginPage loginPage = new LoginPage();
    private final CreateListingPage createListingPage =
            new CreateListingPage();
    private final ListingPage listingPage =
            new ListingPage();

    public DeleteListingSteps(TestContext context) {
        this.context = context;
    }

    @Допустим("у авторизованного пользователя есть объявление для удаления")
    public void authorizedUserHasListingForDeletion() {

        context.setUser(TestDataGenerator.generateUser());
        userApi.createUser(context.getUser());

        mainPage.openLoginPage();
        loginPage.login(context.getUser());
        mainPage.shouldBeAuthorized();

        context.setListing(
                TestDataGenerator.generateListing()
        );

        mainPage.openCreateListingPage();

        createListingPage.createListing(
                context.getListing()
        );

        mainPage.shouldSeeListing(
                context.getListing().getName()
        );
    }

    @Когда("пользователь открывает своё объявление")
    public void userOpensOwnListing() {

        mainPage.openListing(
                context.getListing().getName()
        );
    }

    @Когда("пользователь удаляет объявление")
    public void userDeletesListing() {
        listingPage.deleteListing();
    }

    @Тогда("удалённое объявление не отображается на главной странице")
    public void deletedListingIsNotDisplayed() {

        mainPage.shouldNotSeeListing(
                context.getListing().getName()
        );
    }
}