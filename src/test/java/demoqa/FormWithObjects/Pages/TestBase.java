package demoqa.FormWithObjects.Pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.FormWithObjects.Pages.RegistrationPage.RegistrationPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Test";
    String lastName = "Testov";
    String email = "test@gmail.com";
    String userNumber = "1123456789";
    String Male = "Male";
    String Female = "Female";
    String Other = "Other";
    String Sports = "Sports";
    String Reading = "Reading";
    String Music = "Music";
    File imageFile = new File("src/test/resources/images/testimage1.png");
    String currentAddress = "currentAddress";

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @BeforeEach
     void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

}

