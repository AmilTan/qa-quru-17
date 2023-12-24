package junit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

public class FirstJUnitTest {


    @BeforeAll
    static void beforeAll(){
     //Configuration.holdBrowserOpen = true;
        System.out.println("тесты начались");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("тесты завершились");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("before each сработал");
    }
    @AfterEach
    void afterEach(){
        System.out.println("after each сработал");
    }


    @Test
    void firstTest(){
        System.out.println("тест firstTest сработал");
        Assertions.assertTrue(3>2);
    }


    @Test
    void secondTest(){
        System.out.println("тест secondTest сработал");
        Assertions.assertTrue(3>2);
    }
}
