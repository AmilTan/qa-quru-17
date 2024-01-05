package demoqa.FormWithObjects.Pages;


import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationWithObjectTests extends TestBase {

    @Test
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
                .modalTitleChecker(FormSubmittingTitle)
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
}

    //Второй вариант оформления вызовы метедов (без цепочки)
   /* @Test
    void fillFormTest2() throws InterruptedException {

     /* registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setUserNumber(userNumber);
        registrationPage.ClickGenderButton(Male);
        registrationPage.setBirthDate("08","Sep","1999");
*/




