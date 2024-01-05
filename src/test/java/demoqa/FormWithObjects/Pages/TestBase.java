package demoqa.FormWithObjects.Pages;

import com.codeborne.selenide.Configuration;
import demoqa.FormWithObjects.Pages.RegistrationPage.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

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
    String FormSubmittingTitle = "Thanks for submitting the form";

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
