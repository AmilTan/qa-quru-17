package locators;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples(){

        // EXAMPLE <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
//селектор по type="email" - большая глупость, так как это просто указание HTML, что в этом поле такой тип данных.

        $("[data-testid-email]").setValue("1");
        $(by("data-testid", "email")).setValue("1");
        $("input.login_form_input_box[name=email]#email[data-testid=email]").setValue("1");

      //EXAMPLE  <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]").setValue("1");
        $("#email]").setValue("1");
        $("input#email]").setValue("1");  //input - указание элемента. Что типо не любой id

        $x("//*[@id='email']").setValue("1");
        $x("//input[@id='email']").setValue("1");


        // EXAMPLE <input type="email" class="inputtext login_form_input_box" name="email"
        $("[name=email]").setValue("1");
        $(byName("email")).setValue("1"); //Метод селенида byName СРАЗУ подразумевает что ищем по атрибуту name

        //EXAMPLE  <input type="email" class="inputtext login_form_input_box">
        $("[class=login_form_input_box]").setValue("1");
        $(".login_form_input_box").setValue("1");
        $(".inputtext.login_form_input_box").setValue("1");
        $("input.inputtext.login_form_input_box").setValue("1");

        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("1");


         /* EXAMPLE
         <div class="inputtext">
                <input type="email" class="login_form_input_box">
            </div>
         */

        $(".inputtext .login_form_input_box").setValue("1");
        $(".inputtext").$(".login_form_input_box").setValue("1");

        // <div>Hello qa.guru</div>
        $x("//div[text()='Hello qa.guru']").click();
        $(byText("Hello qa.guru")).click();  //ищет по тексту
        $(withText("lo qa.gur")).click(); //ищет по подстроке


    }
}
