package demoqa.FormWithObjects.Pages;


import com.codeborne.selenide.SelenideElement;
import demoqa.FormWithObjects.Pages.RegistrationPage.Helpers.Attach;
import demoqa.FormWithObjects.Pages.RegistrationPage.RegistrationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Tag("simple")
public class RegistrationWithObjectTests extends TestBase {

    @Test
    @Tag("simple")
    @Feature("Форма регистрации студента")
    @Story("Итоговое окно с данными из формы")
    @Owner("Satoru Gojo")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Позитивный тест: формирование валидной заявки")
    void fillFormTest() throws InterruptedException {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setUserNumber(userNumber)
                .ClickGenderButton(Male)
                .setBirthDate("08","September","1999")
                .setSubject("Maths")
                .setHobbies(Reading)
                .uploadPicture(imageFile)
                .setCurrentAddress(currentAddress)
                .setState("NCR")
                .setCity("Delhi")
                .submitForm()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", firstName+" "+lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", Male)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", "08 September,1999")
                .verifyResult("Subjects", "Maths")
                .verifyResult("Hobbies", Reading)
                .verifyResult("Picture", "testimage1.png")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", "NCR Delhi");
    }


    @Test
    @Tag("simple")
    @Feature("Форма регистрации студента")
    @Story("Итоговое окно с данными из формы")
    @Owner("Satoru Gojo")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Негативный тест: не введен номер телефона")
    void negativeFillFormTest() throws InterruptedException {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
              //  .setUserNumber(userNumber)
                .ClickGenderButton(Male)
                .setBirthDate("08","September","1999")
                .setSubject("Maths")
                .setHobbies(Reading)
                .uploadPicture(imageFile)
                .setCurrentAddress(currentAddress)
                .setState("NCR")
                .setCity("Delhi")
                .submitForm()
                .checkInvalidField($(invalidPhoneSelector));
    }

}






