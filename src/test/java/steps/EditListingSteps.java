package steps;

import api.UserApi;
import context.TestContext;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import model.Listing;
import pages.CreateListingPage;
import pages.EditListingPage;
import pages.ListingPage;
import pages.LoginPage;
import pages.MainPage;
import utils.TestDataGenerator;

public class EditListingSteps {

    private final TestContext context;

    private final UserApi userApi = new UserApi();
    private final MainPage mainPage = new MainPage();
    private final LoginPage loginPage = new LoginPage();
    private final CreateListingPage createListingPage =
            new CreateListingPage();
    private final ListingPage listingPage =
            new ListingPage();
    private final EditListingPage editListingPage =
            new EditListingPage();

    private Listing updatedListing;

    public EditListingSteps(TestContext context) {
        this.context = context;
    }

    @Допустим("у авторизованного пользователя есть объявление для редактирования")
    public void authorizedUserHasListingForEditing() {

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

    @Когда("пользователь открывает своё объявление для редактирования")
    public void userOpensListingForEditing() {

        mainPage.openListing(
                context.getListing().getName()
        );

        listingPage.openEditPage();
    }

    @Когда("пользователь изменяет данные объявления")
    public void userEditsListing() {

        updatedListing =
                TestDataGenerator.generateUpdatedListing(
                        context.getListing()
                );

        editListingPage.editListing(updatedListing);

        context.setListing(updatedListing);
    }

    @Тогда("изменённое объявление отображается на главной странице")
    public void editedListingIsDisplayed() {

        mainPage.shouldSeeListing(
                context.getListing().getName()
        );
    }
}