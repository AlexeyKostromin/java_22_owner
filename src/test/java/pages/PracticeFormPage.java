package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.Color;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private final String expectedColorRed = "#dc3545";
    private final String expectedColorGreen = "#28a745";
    SelenideElement
            firstNameInput = $("[id=firstName]"),
            lastNameInput = $x("//input[@id='lastName']"),
            emailInput = $("[id=userEmail]"),
            genderInput = $("[id=genterWrapper]"),
            phoneInput = $("[id=userNumber]"),
            dateOfBirthInput = $("[id=dateOfBirthInput]"),
            subjectInput = $("[id=subjectsInput]"),
            uploadPictureBtn = $("#uploadPicture"),
            addressInput = $("[id=currentAddress]"),
            stateComboBox = $("[id=state]"),
            stateInput = $("[id=react-select-3-input]"),
            cityComboBox = $("[id=city]"),
            cityInput = $("[id=react-select-4-input]"),
            resultTable = $("[class=table-responsive]"),
            submitBtn = $("[id=submit]");

    @Step("Open main page")
    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        removeFooter();
        return this;
    }
    @Step("Remove footer")
    public PracticeFormPage removeFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Fill first name with value: {firstName}")
    public PracticeFormPage fillFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    @Step("Fill last name with value: {lastName}")
    public PracticeFormPage fillLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    @Step("Fill email with value: {userEmail}")
    public PracticeFormPage fillEmail(String userEmail) {
        emailInput.setValue(userEmail);
        return this;
    }
    @Step("Fill fender with value: {gender}")
    public PracticeFormPage fillGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }
    @Step("Fill phone with value: {phone}")
    public PracticeFormPage fillPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }
    @Step("Fill date with value: {date}")
    public PracticeFormPage setDate(String[] date) {
        dateOfBirthInput.click();
        //new CalendarComponent().selectDate(dayOfBirth, monthOfBirth, yearOfBirth);
        new CalendarComponent().selectDate(date[0], date[1], date[2]);
        return this;
    }
    @Step("Fill subject with value: {subjects}")
    public PracticeFormPage setSubject(String subjects) {
        subjectInput.setValue(subjects).pressEnter();
        return this;
    }
    @Step("Fill hobby with value: {hobby}")
    public PracticeFormPage setHobby(String hobby) {
        $(byText(hobby)).click();
        return this;
    }
    @Step("Upload picture with value: {pictureName}")
    public PracticeFormPage uploadPicture(String pictureName) {
        //$("[id=uploadPicture]").uploadFile(new File("src/test/resources/File1.png"));
        uploadPictureBtn.uploadFromClasspath(pictureName);
        return this;
    }
    @Step("Fill address with value: {address}")
    public PracticeFormPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }
    @Step("Fill state with value: {state}")
    public PracticeFormPage setState(String state) {
        stateComboBox.click();
        stateInput.setValue(state).pressEnter();
        return this;
    }
    @Step("Fill city with value: {city}")
    public PracticeFormPage setCity(String city) {
        cityComboBox.click();
        cityInput.setValue(city).pressEnter();
        return this;
    }
    @Step("Submit form")
    public PracticeFormPage submitForm() {
        submitBtn.click();
        return this;
    }
    @Step("Check result {key} -> should have {value}")
    public PracticeFormPage checkResult(String key, String value) {
        resultTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
    @Step("Verify result table -> should be {flag}")
    public void resultTableShouldBeDisplayed(boolean flag) {
        if (flag) {
            resultTable.should(appear);
        } else {
            resultTable.shouldNot(appear);
        }
    }

    public PracticeFormPage verifyRequiredFieldsColor() {
        sleep(200);
        var colorHexFirstName = Color.fromString(firstNameInput.getCssValue("border-color")).asHex();
        var colorHexLastName = Color.fromString(lastNameInput.getCssValue("border-color")).asHex();
        var colorHexPhone = Color.fromString(phoneInput.getCssValue("border-color")).asHex();

        if (!colorHexFirstName.equals(expectedColorRed)) {
            throw new RuntimeException("firstNameInput color was: " + colorHexFirstName + ", but expected: " + expectedColorRed);
        }
        if (!colorHexLastName.equals(expectedColorRed)) {
            throw new RuntimeException("firstNameInput color was: " + colorHexLastName + ", but expected: " + expectedColorRed);
        }
        if (!colorHexPhone.equals(expectedColorRed)) {
            throw new RuntimeException("firstNameInput color was: " + colorHexPhone + ", but expected: " + expectedColorRed);
        }
        return this;

    }

    public PracticeFormPage verifyNonRequiredFieldsColor() {
        sleep(200);
        var colorHexEmail = Color.fromString(emailInput.getCssValue("border-color")).asHex();
        var colorHexDate = Color.fromString(dateOfBirthInput.getCssValue("border-color")).asHex();
        var colorHexAddress = Color.fromString(addressInput.getCssValue("border-color")).asHex();

        if (!colorHexEmail.equals(expectedColorGreen)) {
            throw new RuntimeException("firstNameInput color was: " + colorHexEmail + ", but expected: " + expectedColorGreen);
        }
        if (!colorHexDate.equals(expectedColorGreen)) {
            throw new RuntimeException("firstNameInput color was: " + colorHexDate + ", but expected: " + expectedColorGreen);
        }
        if (!colorHexAddress.equals(expectedColorGreen)) {
            throw new RuntimeException("firstNameInput color was: " + colorHexAddress + ", but expected: " + expectedColorGreen);
        }
        return this;
    }

}
