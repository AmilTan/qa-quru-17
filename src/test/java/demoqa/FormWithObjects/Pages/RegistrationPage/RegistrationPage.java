package demoqa.FormWithObjects.Pages.RegistrationPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import demoqa.FormWithObjects.Pages.Components.CalendarComponent;
import demoqa.FormWithObjects.Pages.Components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
CalendarComponent calendarComponent = new CalendarComponent();
RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private final SelenideElement
            firstNameInput = $("input#firstName.mr-sm-2.form-control"),
            lastNameInput = $("input#lastName.mr-sm-2.form-control"),
            emailInput = $("input#userEmail.mr-sm-2.form-control"),
            userNumberInput = $("input#userNumber.mr-sm-2.form-control"),
            genderMale = $("#gender-radio-1 + label"),//
    // $("input#gender-radio-1").parent().$("label").click(); этот вариан тоже рабочий.
            genderWomen = $("#gender-radio-2 + label"),
            genderOther = $("#gender-radio-3 + label"),
            dateOfBirthInput = $("input#dateOfBirthInput"),
            subjectInput =  $("input#subjectsInput"),
            hobbieSports =  $("#hobbies-checkbox-1 + label"),
            hobbieReading =  $("#hobbies-checkbox-2 + label"),
            hobbieMusic =  $("#hobbies-checkbox-3 + label"),
            pictureInput =  $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("input#react-select-3-input"),
            cityInput = $("input#react-select-4-input"),
            submitConfirmation = $("#submit"),
            modalTitle = $("#example-modal-sizes-title-lg");



    //Первый вариант

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage ClickGenderButton(String value) {
        switch (value) {
            case "Male":
                genderMale.click();
                break;
            case "Female":
                genderWomen.click();
                break;
            case "Other":
                genderOther.click();
                break;
        }
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        switch (value) {
            case "Sports":
                hobbieSports.click();
                break;
            case "Reading":
                hobbieReading.click();
                break;
            case "Music":
                hobbieMusic.click();
                break;
        }
        return this;
    }

    public RegistrationPage uploadPicture(File file) {
        pictureInput.uploadFile(file);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submitForm() {
        submitConfirmation.pressEnter();
        return this;
    }
    public RegistrationPage modalTitleChecker(String value) {
        modalTitle.shouldHave(text((value)));
        return this;
    }




    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

}




    /* Второй вариант методов без возврата.(Без цепочек)

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void setEmail(String value) {
        emailInput.setValue(value);
    }

    public void setUserNumber(String value) {
        userNumberInput.setValue(value);
    }

    public void ClickGenderButton(String value) {
        switch (value) {
            case "Male":
                genderMale.click();
                break;
            case "Female":
                genderWomen.click();
                break;
            case "Other":
                genderOther.click();
                break;
        }
    }
    public void setBirthDate(String day, String month, String year) {
        $("input#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
    }

     */





