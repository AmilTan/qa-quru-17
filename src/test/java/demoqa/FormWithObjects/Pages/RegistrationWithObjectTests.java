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
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setUserNumber(userNumber);
        registrationPage.ClickGenderButton(Male);
        registrationPage.setBirthDate("08","September","1999");
        registrationPage.setSubject("Maths");
        registrationPage.setHobbies(Reading);
        registrationPage.uploadPicture(imageFile);
        registrationPage.setCurrentAddress(currentAddress);
        registrationPage.setState("NCR");
        registrationPage.setCity("Delhi");
        registrationPage.submitForm();
        registrationPage.verifyResultsModalAppears();
        registrationPage.verifyResult("Student Name", firstName+" "+lastName);
        registrationPage.verifyResult("Student Email", email);
        registrationPage.verifyResult("Gender", Male);
        registrationPage.verifyResult("Mobile", userNumber);
        registrationPage.verifyResult("Date of Birth", "08 September,1999");
        registrationPage.verifyResult("Subjects", "Maths");
        registrationPage.verifyResult("Hobbies", Reading);
        registrationPage.verifyResult("Picture", "testimage1.png");
        registrationPage.verifyResult("Address", currentAddress);
        registrationPage.verifyResult("State and City", "NCR Delhi");
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
        RegistrationPage registrationPage = new RegistrationPage();
                registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
              //  .setUserNumber(userNumber)
        registrationPage.ClickGenderButton(Male);
        registrationPage.setBirthDate("08","September","1999");
        registrationPage.setSubject("Maths");
        registrationPage.setHobbies(Reading);
        registrationPage.uploadPicture(imageFile);
        registrationPage.setCurrentAddress(currentAddress);
        registrationPage.setState("NCR");
        registrationPage.setCity("Delhi");
        registrationPage.submitForm();
        registrationPage.checkInvalidField($(invalidPhoneSelector));
    }

}






