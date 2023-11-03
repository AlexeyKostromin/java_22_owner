package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.AttachHelper;
import helpers.RandomStudentDataGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import io.qameta.allure.selenide.AllureSelenide;


public class StudentRegistrationFormTest extends TestBase {
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        AttachHelper.takeScreenshotAs("Last screenshot");
        AttachHelper.pageSource();
        AttachHelper.browserConsoleLogs();
        AttachHelper.addVideo();
    }

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Tag("Smoke")
    @Test
    void successSubmitAllFormTest() {

        RandomStudentDataGenerator rsd = new RandomStudentDataGenerator();

        practiceFormPage
                .openPage()
                .fillFirstName(rsd.firstName)
                .fillLastName(rsd.lastName)
                .fillEmail(rsd.userEmail)
                .fillGender(rsd.gender)
                .fillPhone(rsd.phone)
                .setDate(rsd.dateOfBirth)
                .setSubject(rsd.subjects)
                .setHobby(rsd.hobby)
                .uploadPicture(rsd.fileName)
                .setAddress(rsd.address)
                .setState(rsd.state)
                .setCity(rsd.city)
                .submitForm()
                .resultTableShouldBeDisplayed(true);

        practiceFormPage
                .checkResult("Student Name", rsd.firstName + " " + rsd.lastName)
                .checkResult("Student Email", rsd.userEmail)
                .checkResult("Gender", rsd.gender)
                .checkResult("Mobile", rsd.phone)
                .checkResult("Date of Birth", rsd.dateOfBirth[0] + " " + rsd.dateOfBirth[1] + "," + rsd.dateOfBirth[2])
                .checkResult("Subjects", rsd.subjects)
                .checkResult("Hobbies", rsd.hobby)
                .checkResult("Picture", rsd.fileName)
                .checkResult("Address", rsd.address)
                .checkResult("State and City", rsd.state + " " + rsd.city);
    }

    @Test
    void successSubmitRequiredFormTest() {

        RandomStudentDataGenerator rsd = new RandomStudentDataGenerator();

        practiceFormPage
                .openPage()
                .fillFirstName(rsd.firstName)
                .fillLastName(rsd.lastName)
                .fillGender(rsd.gender)
                .fillPhone(rsd.phone)
                .submitForm()
                .resultTableShouldBeDisplayed(true);

        practiceFormPage
                .checkResult("Student Name", rsd.firstName + " " + rsd.lastName)
                .checkResult("Gender", rsd.gender)
                .checkResult("Mobile", rsd.phone);
    }


    @Test
    @Tag("Simple")
    void failSubmitFormWithEmptyValuesTest() {
        practiceFormPage
                .openPage()
                .submitForm()
                .resultTableShouldBeDisplayed(false);

        practiceFormPage
                .verifyRequiredFieldsColor()
                .verifyNonRequiredFieldsColor();
    }

}
