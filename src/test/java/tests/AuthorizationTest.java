package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.Assertions;
import lib.BaseTestCase;
import lib.DataGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorizationTest extends BaseTestCase {
    @Test
    @DisplayName("Авторизация зарегистрированного пользователя")
    public void testAuthorization() {
        Response responseAuth = this.login(
                "/login",
                DataGenerator.getAuthData()
        );

        Assertions.assertResponseCodeEquals(responseAuth, 200);
        Assertions.assertJsonHasField(responseAuth, "access_token");
    }

    @Test
    @DisplayName("Авторизация незарегистрированного пользователя")
    public void testAuthorizationOfUnregisteredUser() {
        Response responseAuth = this.login(
                "/login",
                DataGenerator.getAuthDataOfUnregisteredUser()
        );

        Assertions.assertResponseCodeEquals(responseAuth, 401);
    }

    @Test
    @DisplayName("Авторизация зарегистрированного пользователя с неверным паролем")
    public void testAuthorizationWithWrongEmail() {
        Response responseAuth = this.login(
                "/login",
                DataGenerator.getAuthDataWithWrongEmail()
        );

        Assertions.assertResponseCodeEquals(responseAuth, 401);
    }
}
