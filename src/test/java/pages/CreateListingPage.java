package pages;

import model.Listing;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CreateListingPage {

    public void shouldBeOpened() {
        $x("//*[normalize-space(text())='Новое объявление']")
                .shouldBe(visible);
    }

    public void createListing(Listing listing) {
        $("[name='name']")
                .setValue(listing.getName());

        $("[name='category']")
                .shouldHave(value(listing.getCategory()));

        $("[name='condition'][value='" + listing.getCondition() + "']")
                .shouldBe(selected);

        $("[name='city']")
                .shouldHave(value(listing.getCity()));

        $("textarea[name='description']")
                .setValue(listing.getDescription());

        $("[name='price']")
                .setValue(listing.getPrice());

        $x("//button[@type='submit' and normalize-space(.)='Опубликовать']")
                .click();
    }
}