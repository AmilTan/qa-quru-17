package demoqa.FormWithObjects.Pages;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;


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
                .setMobile(userNumber)
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

  //  @Disabled("отключен для теста")
    @Test
    @Tag("simple")
    @Tag("negative")
    @Feature("Форма регистрации студента")
    @Story("Итоговое окно с данными из формы")
    @Owner("Satoru Gojo")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Негативный тест: не введено имя")
    void doNotEnterFirstName() throws InterruptedException {
        registrationPage.openPage()
               // .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setMobile(userNumber)
                .ClickGenderButton(Male)
                .setBirthDate("08","September","1999")
                .setSubject("Maths")
                .setHobbies(Reading)
                .uploadPicture(imageFile)
                .setCurrentAddress(currentAddress)
                .setState("NCR")
                .setCity("Delhi")
                .submitForm()
                .checkInvalidField($(invalidFirstNameSelector));
    }
//  @Disabled("отключен для теста")
    @Test
    @Tag("simple")
    @Tag("negative")
    @Feature("Форма регистрации студента")
    @Story("Итоговое окно с данными из формы")
    @Owner("Satoru Gojo")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Негативный тест: не введен номер телефона")
    void doNotEnterPhoneNumber() throws InterruptedException {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
//                .setMobile(userNumber)
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

    //  @Disabled("отключен для теста")
    @Test
    @Tag("simple")
    @Tag("negative")
    @Feature("Форма регистрации студента")
    @Story("Итоговое окно с данными из формы")
    @Owner("Satoru Gojo")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Негативный тест: не введена фамилия")
    void doNotEnterLastName() throws InterruptedException {
        registrationPage.openPage()
                .setFirstName(firstName)
   //             .setLastName(lastName)
                .setEmail(email)
                .setMobile(userNumber)
                .ClickGenderButton(Male)
                .setBirthDate("08","September","1999")
                .setSubject("Maths")
                .setHobbies(Reading)
                .uploadPicture(imageFile)
                .setCurrentAddress(currentAddress)
                .setState("NCR")
                .setCity("Delhi")
                .submitForm()
                .checkInvalidField($(invalidLastNameSelector));
    }




}






