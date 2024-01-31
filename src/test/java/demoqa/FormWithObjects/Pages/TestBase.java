package demoqa.FormWithObjects.Pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.FormWithObjects.Pages.RegistrationPage.Helpers.Attach;
import demoqa.FormWithObjects.Pages.RegistrationPage.RegistrationPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

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
    String invalidPhoneSelector = "input#userNumber.mr-sm-2.form-control:invalid";


    @BeforeAll
    static void beforeAll() {

            Configuration.baseUrl = "https://demoqa.com";
            Configuration.holdBrowserOpen = true;
            Configuration.browser = "chrome";
            Configuration.browserVersion = "100.0";
            Configuration.browserSize = "1920x1080";

    }
    @BeforeEach
     void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
     }

}

