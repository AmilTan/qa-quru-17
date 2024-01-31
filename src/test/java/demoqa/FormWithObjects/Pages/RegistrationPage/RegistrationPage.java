package demoqa.FormWithObjects.Pages.RegistrationPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import demoqa.FormWithObjects.Pages.RegistrationPage.Components.CalendarComponent;
import demoqa.FormWithObjects.Pages.RegistrationPage.Components.RegistrationResultsModal;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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
            googlePopup = $(".fc-dialog-container"),
            googlePopupAgreeButton = $(".fc-button.fc-cta-consent.fc-primary-button");



    @Step("Открываем страницу с формой регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
       if (googlePopup.exists()) {
           googlePopupAgreeButton.click();
       }

        return this;
    }
    @Step("Указали Имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Указали Фамилию")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Указали Email")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }
    @Step("Указали телефон")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    @Step("Выбрали гендер")
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
    @Step("Указали день рождения")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    @Step("Выбрали дисциплину")
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Указали хобби")
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
    @Step("Загрузили картинку")
    public RegistrationPage uploadPicture(File file) {
        pictureInput.uploadFile(file);
        return this;
    }
    @Step("Указали адрес")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    @Step("Указали штат")
    public RegistrationPage setState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Указали город")
    public RegistrationPage setCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Подтвердили форму с данными")
    public RegistrationPage submitForm() {
        submitConfirmation.pressEnter();
        return this;
    }

    @Step("Проверили, что итоговая форма появилась")
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    @Step("Проверили, что установленное значение для {key} отображается корректно: {value}")
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    //Методы для негативных тестов
    @Step("Проверили, что обязательное поле приняло состояние невалидного - {field}")
    public RegistrationPage checkInvalidField(SelenideElement field) {
       // field.shouldHave(cssValue("border-top-color", "rgb(220, 53, 69)"));
        field.shouldBe(visible);
        return this;
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl()
                + "' type='video/mp4'></video></body></html>";
    }

    public URL getVideoUrl() {
        String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId() + ".mp4";
//        System.out.println(sessionId());
        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}





