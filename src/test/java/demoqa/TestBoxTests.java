package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void fillFormTest(){
         open("/text-box");
         $(".main-header").shouldHave(Condition.text("Text Box"));
         //Full Name
         $("#userName").setValue("Test Testov");
         //Email
         $("#userEmail").setValue("test@gmail.com");
         //Current Address
         $("#currentAddress").setValue("test ave 32");
         //Permanent Address
         $("#permanentAddress").setValue("permanent ave 36");
         //Click
         $("#submit").click();

         //блок с итоговыми данными виден
         $("#output").shouldBe(visible);

         //каждое поле соответствует введеным ранее данным
         $("#output").$("#name").shouldHave(text("Test Testov"));
         $("#output").$("#email").shouldHave(text("test@gmail.com"));
         $("#output").$("#currentAddress").shouldHave(text("test ave 32"));
         $("#output").$("#permanentAddress").shouldHave(text("permanent ave 36"));



    }
}
