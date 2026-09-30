package pages;

import model.Listing;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class EditListingPage {

    public void editListing(Listing listing) {

        $("[name='name']")
                .shouldBe(visible)
                .setValue(listing.getName());

        $("[name='price']")
                .shouldBe(visible)
                .setValue(listing.getPrice());

        $x("//button[contains(., 'Сохранить изменения')]")
                .shouldBe(visible)
                .click();
    }
}