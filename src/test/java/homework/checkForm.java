package homework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;


public class checkForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() throws InterruptedException {
        open("/automation-practice-form");

        //name
        $("input#firstName.mr-sm-2.form-control").setValue("Test");

        //lastname
        $("input#lastName.mr-sm-2.form-control").setValue("Testov");

        //mail
        $("input#userEmail.mr-sm-2.form-control").setValue("test@gmail.com");

        //radiobutton Male

        //$("input#gender-radio-1").parent().$("label").click(); этот вариан тоже рабочий.

        $("#gender-radio-1 + label").click();


        //userNumber
        $("input#userNumber.mr-sm-2.form-control").setValue("1123456789");

        //DateOfBirth
        $("input#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__day.react-datepicker__day--008").click();

        //Subject!
        $("input#subjectsInput").setValue("Maths").pressEnter();

        //checkbox Hobbies
        $("#hobbies-checkbox-2 + label").click();

        // upload file
       File imageFile = new File("src/test/resources/images/testimage1.png");
        $("#uploadPicture").uploadFile(imageFile);

        // currentAddress
        $("#currentAddress").setValue("currentAddress");

        //State
        $("input#react-select-3-input").setValue("NCR").pressEnter();

        //City
        $("input#react-select-4-input").setValue("Delhi").pressEnter();

        //Submit
        $("#submit").pressEnter();




        //Assertions
        //name
        $("input#firstName.mr-sm-2.form-control").shouldHave(value("Test"));
        //lastname
        $("input#lastName.mr-sm-2.form-control").shouldHave(value("Testov"));
        //email
        $("input#userEmail.mr-sm-2.form-control").shouldHave(value("test@gmail.com"));
        //radiobutton
        $("#gender-radio-1").shouldBe(selected);
        //userNumber
        $("input#userNumber.mr-sm-2.form-control").shouldHave(value("1123456789"));

        //calendar
        $("input#dateOfBirthInput").shouldHave(value("08 Sep 1999"));

        //Subject
       $(".css-12jo7m5.subjects-auto-complete__multi-value__label").shouldHave(text("Maths"));

        //checkbox hobbies
        $("#hobbies-checkbox-2").shouldBe(checked); //Метод shouldBe(checked) работает непосредственно с атрибутом checked элемента <input type="checkbox">, а не с меткой label.
        // upload file
        //$("#uploadPicture").shouldHave(partialValue("testimage1.png"));
        $("#uploadPicture").shouldHave(value("testimage1.png"));

        // currentAddress
        $("#currentAddress").shouldHave(value("currentAddress"));

        //State
        $("#state").shouldHave(text("NCR"));

        //City
        $("#city").shouldHave(text("Delhi"));

        //FinalApprove
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));



    }
}
